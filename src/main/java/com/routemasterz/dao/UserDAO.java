package com.routemasterz.dao;

import com.routemasterz.model.UserEntity;

public interface UserDAO {
    UserEntity findUserByEmail(String email);
}
