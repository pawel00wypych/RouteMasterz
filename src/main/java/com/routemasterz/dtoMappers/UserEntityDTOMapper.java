package com.routemasterz.dtoMappers;

import com.routemasterz.dto.UserDTO;
import com.routemasterz.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserEntityDTOMapper implements Function<UserEntity, UserDTO> {

    @Override
    public UserDTO apply(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getEmail(),
                userEntity.getRole(),
                userEntity.getCreatedAt()
        );
    }
}