package com.routemasterz.dao;

import com.routemasterz.dto.ExtendedUserDetailsDTO;
import com.routemasterz.model.Role;
import com.routemasterz.model.UserEntity;
import com.routemasterz.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public void setNewPassword(long id, String password) {
        userRepository.setNewPassword(id, password);
    }

    @Override
    public List<UserEntity> getAllNonAdminUsers() {
        return userRepository.getAllNonAdminUsers();
    }

    @Override
    public void changeUserRole(Long userId, String newRole) {
        userRepository.changeUserRole(userId, newRole);
    }

    @Override
    public void changeUserCompany(Long userId, String company) {
        userRepository.changeUserCompany(userId, company);
    }
}
