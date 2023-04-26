package com.routemasterz.dao;

import com.routemasterz.model.UserEntity;
import com.routemasterz.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository("jpa")
public class UserJPADataAccessService implements UserDAO{

    private final UserRepository userRepository;

    public UserJPADataAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
