package com.routemasterz.service;

import com.routemasterz.dao.UserDAO;
import com.routemasterz.dao.UserDetailsDAO;
import com.routemasterz.dto.GetUserRequest;
import com.routemasterz.dto.SetPhoneRequest;
import com.routemasterz.dto.SetNewPasswordRequest;
import com.routemasterz.dtoMappers.UserDetailsDTOMapper;
import com.routemasterz.dtoMappers.UserEntityDTOMapper;
import com.routemasterz.model.UserEntity;
import com.routemasterz.model.UserEntityDetails;
import com.routemasterz.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final UserDetailsDAO userDetailsDAO;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    Logger logger = LoggerFactory.getLogger(LogoutService.class);

    public UserService(@Qualifier("jpa") UserDAO userDAO,
                       @Qualifier("userDetailsJpa") UserDetailsDAO userDetailsDAO,
                       JWTUtil jwtUtil,
                       PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.userDetailsDAO = userDetailsDAO;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> getLoggedUser(GetUserRequest request) {
        try {
            String email = jwtUtil.getSubject(request.token());
            UserEntity user = userDAO.findUserByEmail(email);
            UserEntityDTOMapper mapper = new UserEntityDTOMapper();
            return new ResponseEntity<>(mapper.apply(user), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> setNewPhone(SetPhoneRequest request) {
        try {
            String email = jwtUtil.getSubject(request.token());
            UserEntity user = userDAO.findUserByEmail(email);
            userDetailsDAO.setNewPhone(user.getUserEntityDetails().getId(), request.phoneNumber());
            return new ResponseEntity<>("Phone number changed", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> setNewPassword(SetNewPasswordRequest request) {
        try {
            String email = jwtUtil.getSubject(request.token());
            UserEntity user = userDAO.findUserByEmail(email);
            logger.warn("old password: "+user.getPassword());
            logger.warn("request old password: "+request.oldPassword());
            logger.warn("request old password encoded: "+passwordEncoder.encode(request.oldPassword()));
            if(passwordEncoder.matches(request.oldPassword(), user.getPassword())) {

                if(request.newPassword().equals(request.confirmPassword())) {
                    userDAO.setNewPassword(user.getId(), passwordEncoder.encode(request.newPassword()));
                    return new ResponseEntity<>("Password changed", HttpStatus.OK);
                }
                return new ResponseEntity<>("Passwords are not equal!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Old Password is not correct!", HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getUserDetails(GetUserRequest request) {
        try {
            String email = jwtUtil.getSubject(request.token());
            UserEntityDetails userDetails = userDetailsDAO.findUserInfoByEmail(email);
            UserDetailsDTOMapper mapper = new UserDetailsDTOMapper();
            return new ResponseEntity<>(mapper.apply(userDetails), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
