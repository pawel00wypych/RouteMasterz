package com.routemasterz.dao;

import com.routemasterz.dto.ExtendedUserDetailsDTO;
import com.routemasterz.model.Role;
import com.routemasterz.model.UserEntity;

import java.util.List;

public interface UserDAO {
    UserEntity findUserByEmail(String email);

    boolean existsUserWithEmail(String email);

    void save(UserEntity userEntity);

    void setNewPassword(long id, String encode);

    List<UserEntity> getAllNonAdminUsers();

    void changeUserRole(Long userId, String newRole);

    void changeUserCompany(Long userId, String company);
}
