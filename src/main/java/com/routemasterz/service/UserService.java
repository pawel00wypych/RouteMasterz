package com.routemasterz.service;

import com.routemasterz.dto.SetEmailRequest;
import com.routemasterz.dto.SetNewPasswordRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String logout() {
        return "logged out";
    }

    public String setEmail(SetEmailRequest request) {
        return "new email is set";
    }

    public String setNewPassword(SetNewPasswordRequest request) {
        return "new password is set";
    }
}
