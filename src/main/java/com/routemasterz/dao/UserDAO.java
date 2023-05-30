package com.routemasterz.dao;

import com.routemasterz.model.UserEntity;

public interface UserDAO {
    UserEntity findUserByEmail(String email);

    boolean existsUserWithEmail(String email);

    void save(UserEntity userEntity);

    void setNewPassword(long id, String encode);
}
