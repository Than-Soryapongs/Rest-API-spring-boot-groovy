package com.pongs.demo.dto.request

import jakarta.validation.constraints.NotBlank

public class LoginRequest {

    @NotBlank(message = "User is required")
    String user;

    @NotBlank(message = "Password is required")
    String password;
}