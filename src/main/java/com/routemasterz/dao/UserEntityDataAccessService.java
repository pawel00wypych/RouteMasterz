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
    public Optional<UserEntityDetails> findUserInfoByEmail(String email) {
        return Optional.ofNullable(repository.findUserEntityDetailsByEmail(email));
    }
}
