package com.routemasterz.dto;

import com.routemasterz.model.Role;

public record ExtendedUserDetailsDTO(Long userEntityId,
                                     String name,
                                     String surname,
                                     String email,
                                     int phoneNumber,
                                     Role role) {
}
