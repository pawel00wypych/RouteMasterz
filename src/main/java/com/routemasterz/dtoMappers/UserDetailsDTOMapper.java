package com.routemasterz.dtoMappers;

import com.routemasterz.dto.UserInfoDTO;
import com.routemasterz.model.UserEntityDetails;

import java.util.function.Function;

public class UserDetailsDTOMapper implements Function<UserEntityDetails, UserInfoDTO> {
    @Override
    public UserInfoDTO apply(UserEntityDetails userEntityDetails) {
        return new UserInfoDTO(userEntityDetails.getName(),
                userEntityDetails.getSurname(),
                userEntityDetails.getResidence(),
                userEntityDetails.getCompany(),
                userEntityDetails.getPhoneNumber(),
                userEntityDetails.getProfilePhotoSource(),
                userEntityDetails.getCreatedAt());
    }
}
