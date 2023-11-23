package com.wedogift.backend.config;

import com.wedogift.backend.entities.CompanyEntity;
import com.wedogift.backend.entities.UserEntity;
import com.wedogift.backend.repos.CompaniesRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DbInitializer implements CommandLineRunner {

    private final CompaniesRepo companiesRepo;

    public DbInitializer(CompaniesRepo companiesRepo) {
        this.companiesRepo = companiesRepo;
    }


    @Override
    public void run(String... args)  {
		this.companiesRepo.deleteAll();

        companiesRepo.save(CompanyEntity.builder().name("Tesla").balance(100.0).users(List.of(UserEntity.builder().name("John").build())).build());
        companiesRepo.save(CompanyEntity.builder().name("Addidas").balance(150.0).users(List.of(UserEntity.builder().name("James").build())).build());
        companiesRepo.save(CompanyEntity.builder().name("Nike").balance(10.0).users(List.of(UserEntity.builder().name("Peter").build())).build());
        companiesRepo.findAll().forEach(t -> {
            log.info("{} Company : {} ", "[APILOG]", t);
        });
    }

}
