package com.routemasterz.dto;

public record UserInfoDTO(String name,
                          String surname,
                          String residence,
                          String company,
                          int phoneNumber,
                          String profilePhotoSource,
                          String createdAt) {
}
