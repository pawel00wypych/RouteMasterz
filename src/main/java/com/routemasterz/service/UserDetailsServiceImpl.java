package com.routemasterz.service;

import com.routemasterz.dao.UserDAO;
import com.routemasterz.model.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDAO userDAO;

    public UserDetailsServiceImpl(@Qualifier("jpa") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity =  userDAO.findUserByEmail(email);
        if(userEntity == null)
            throw (new UsernameNotFoundException("Email " + email + " not found"));
        return userEntity;
    }
}
