package com.routemasterz.dao;

import com.routemasterz.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository("jpa")
public class UserJPADataAccessService implements UserDAO{

    private final UserRepository userRepository;

    public UserJPADataAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
