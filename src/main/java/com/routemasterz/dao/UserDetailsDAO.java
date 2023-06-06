package com.routemasterz.dao;

import com.routemasterz.model.UserEntityDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsDAO {

    UserEntityDetails findUserInfoByEmail(String email);

    void setNewPhone(Long id, int phoneNumber);
}
