package com.routemasterz.service;

import com.routemasterz.dao.UserDAO;
import com.routemasterz.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final UserDetailsDTOMapper userDetailsDTOMapper;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserService(@Qualifier("jpa") UserDAO userDAO, UserDetailsDTOMapper userDetailsDTOMapper, UserDTOMapper userDTOMapper) {
        this.userDAO = userDAO;
        this.userDetailsDTOMapper = userDetailsDTOMapper;
        this.userDTOMapper = userDTOMapper;
    }

}
