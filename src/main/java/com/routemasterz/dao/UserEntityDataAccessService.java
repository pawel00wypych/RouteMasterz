package com.routemasterz.dao;

import com.routemasterz.model.UserEntityDetails;
import com.routemasterz.repository.UserEntityDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userDetailsJpa")
public class UserEntityDataAccessService implements UserDetailsDAO{

    private final UserEntityDetailsRepository repository;

    public UserEntityDataAccessService(UserEntityDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntityDetails findUserInfoByEmail(String email) {
        return repository.findUserEntityDetailsByEmail(email);
    }

    @Override
    public void setNewPhone(Long id, int phoneNumber) {
        repository.setNewPhone(id, phoneNumber);
    }
}
