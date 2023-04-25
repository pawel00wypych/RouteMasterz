package com.routemasterz.dao;

import com.routemasterz.model.UserEntityDetails;

import java.util.Optional;

public interface UserDetailsDAO {

    Optional<UserEntityDetails> findUserInfoByEmail(String email);
}
