package com.pongs.demo.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import jakarta.validation.Valid
import com.pongs.demo.dto.request.LoginRequest
import com.pongs.demo.dto.response.LoginResponse
import groovy.util.logging.Slf4j

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    ResponseEntity<LoginResponse> Login(@RequestBody @Valid LoginRequest loginRequest) {

        log.info("Login request received: ${loginRequest.user}");

        boolean authenticated = loginRequest.user == "admin" && loginRequest.password == "password";

        LoginResponse loginResponse;
        if(authenticated) {
            loginResponse = new LoginResponse("success", "Login successful");
        } else {
            loginResponse = new LoginResponse("failure", "Invalid username or password");
        }

        log.info("Login response: ${loginResponse.status} - ${loginResponse.message}");

        return ResponseEntity.ok(loginResponse);
    }
    
}