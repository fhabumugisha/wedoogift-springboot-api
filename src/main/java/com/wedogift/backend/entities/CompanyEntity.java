package com.wedogift.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;


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

    public void addUser(UserEntity userEntity) {
        users.add(userEntity);
        userEntity.setCompany(this);
    }

    public void removeUser(UserEntity userEntity) {
        users.remove(userEntity);
        userEntity.setCompany(null);
    }
}
