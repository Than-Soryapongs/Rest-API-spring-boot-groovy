package com.pongs.demo.dto.response

public class LoginResponse {
    String status;
    String message;

    LoginResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}