package com.wedogift.backend.services;

import com.wedogift.backend.mappers.CompaniesMapper;
import com.wedogift.backend.mappers.UsersMapper;
import com.wedogift.backend.repos.CompaniesRepo;
import com.wedogift.backend.repos.UsersRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompaniesServiceImplTest {

    @Mock private CompaniesMapper companiesMapper;
    @Mock private UsersMapper usersMapper;
    @Mock private UsersRepo usersRepo;

    @Mock private CompaniesRepo companiesRepo;

    @InjectMocks   private CompaniesServiceImpl companiesService;


    @Test
    void addCompany() {
    }

    @Test
    void getAllCompanies() {
    }

    @Test
    void getCompany() {
    }

    @Test
    void addUserToCompany() {
    }

    @Test
    void getCompanyUsers() {
    }

    @Test
    void getCompanyUser() {
    }

    @Test
    void depositBalanceToUser() {
    }

    @Test
    void getUserBalance() {
    }
}