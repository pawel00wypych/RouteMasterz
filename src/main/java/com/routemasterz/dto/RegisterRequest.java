package com.routemasterz.dto;

public record RegisterRequest(String email,
                              String password,
                              String passwordConfirmation,
                              String name,
                              String surname,
                              String residence,
                              Integer phoneNumber) {
}
