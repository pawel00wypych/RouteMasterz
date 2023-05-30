package com.routemasterz.dto;

public record SetNewPasswordRequest(String token,
                                    String oldPassword,
                                    String newPassword,
                                    String confirmPassword) {
}
