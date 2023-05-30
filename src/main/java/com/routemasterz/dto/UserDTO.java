package com.routemasterz.dto;

import com.routemasterz.model.Role;

public record UserDTO(
        String email,
        Role role,
        String createdAt
) {
}
