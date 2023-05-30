package com.routemasterz.service;

import com.routemasterz.dao.UserDAO;
import com.routemasterz.dto.GetUserRequest;
import com.routemasterz.dto.SetEmailRequest;
import com.routemasterz.dto.SetNewPasswordRequest;
import com.routemasterz.model.UserEntity;
import com.routemasterz.util.JWTUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    private final JWTUtil jwtUtil;

    public UserService(@Qualifier("jpa") UserDAO userDAO, JWTUtil jwtUtil) {
        this.userDAO = userDAO;
        this.jwtUtil = jwtUtil;
    }

    public String logout() {
        return "logged out";
    }

    public String setEmail(SetEmailRequest request) {
        return "new email is set";
    }

    public String setNewPassword(SetNewPasswordRequest request) {
        return "new password is set";
    }

    public ResponseEntity<?> getLoggedUser(GetUserRequest request) {
        try {
            String email = jwtUtil.getSubject(request.token());
            UserEntity user = userDAO.findUserByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
