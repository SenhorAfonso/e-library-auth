package com.sirafonso.e_library_users.adapters.in.web.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping("/register")
    public String registerUser() {
        return "registering user";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "login user";
    }

}
