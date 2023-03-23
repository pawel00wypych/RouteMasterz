package com.routemasterz.dtoMappers;

import com.routemasterz.dto.UserDTO;
import com.routemasterz.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getEmail(),
                user.getRole(),
                user.getActive()
        );
    }
}