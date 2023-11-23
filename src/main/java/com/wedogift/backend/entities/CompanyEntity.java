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
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false, insertable = false, updatable = false)
    protected UUID id;
    private String name;
    private Double balance;
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    private List<UserEntity> users = new ArrayList<>();
}
