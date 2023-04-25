package com.routemasterz.service;

import com.routemasterz.dao.UserDAO;
import com.routemasterz.dao.UserDetailsDAO;
import com.routemasterz.dto.*;
import com.routemasterz.dtoMappers.UserEntityDTOMapper;
import com.routemasterz.model.Role;
import com.routemasterz.model.UserEntity;
import com.routemasterz.model.UserEntityDetails;
import com.routemasterz.util.JWTUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserEntityDTOMapper userEntityDTOMapper;
    private final UserDetailsDAO userDetailsDAO;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserDAO userDAO;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 UserEntityDTOMapper userEntityDTOMapper,
                                 @Qualifier("userDetailsJpa") UserDetailsDAO userDetailsDAO,
                                 JWTUtil jwtUtil, PasswordEncoder passwordEncoder, UserDAO userDAO) {
        this.authenticationManager = authenticationManager;
        this.userEntityDTOMapper = userEntityDTOMapper;
        this.jwtUtil = jwtUtil;
        this.userDetailsDAO = userDetailsDAO;
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    public ResponseEntity<?> login(AuthenticationRequest request) {
        try {
            Authentication authentication;

            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );

            UserEntity principal = (UserEntity) authentication.getPrincipal();
            UserDTO userDTO = userEntityDTOMapper.apply(principal);
            String token = jwtUtil.issueToken(userDTO.email(), userDTO.role().toString());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Optional<UserEntityDetails> userInfo = userDetailsDAO.findUserInfoByEmail(userDTO.email());

            return new ResponseEntity<>(new AuthenticationResponse(token, "", "", "", "Login success"), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(new AuthenticationFailedResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> register(RegisterRequest request) {

        if (userDAO.existsUserWithEmail(request.email())) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            return new ResponseEntity<>(new AuthenticationFailedResponse("Email is taken!"), HttpStatus.BAD_REQUEST);
        }

        if (!request.password().equals(request.passwordConfirmation())) {
            return new ResponseEntity<>(new AuthenticationFailedResponse("Passwords are not equal!"), HttpStatus.BAD_REQUEST);
        }
        UserEntityDetails userInfo = new UserEntityDetails(
                request.name(),
                request.surname(),
                request.residence(),
                "",
                111222333,
                "",
                LocalDate.now().toString()
        );

        UserEntity userEntity = new UserEntity(
                Role.DRIVER,
                request.email(),
                passwordEncoder.encode(request.password()),
                LocalDate.now().toString(),
                userInfo
        );

        userDAO.save(userEntity);

        return new ResponseEntity<>(new RegisterResponse("User " + userInfo.getName() + " registered successfully"), HttpStatus.OK);
    }

}
