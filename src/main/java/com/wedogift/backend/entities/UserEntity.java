package com.wedogift.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false, insertable = false, updatable = false)
    protected UUID id;
    private String name;
    @ManyToOne
    @JoinColumn(name="company_id")
    private CompanyEntity company;
    // List of deposits made by the user
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DepositEntity> deposits = new ArrayList<>();
}
