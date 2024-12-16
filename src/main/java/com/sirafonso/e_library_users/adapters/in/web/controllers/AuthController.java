package com.sirafonso.e_library_users.adapters.in.web.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sirafonso.e_library_users.adapters.in.web.controllers.dtos.request.LoginUserRequest;
import com.sirafonso.e_library_users.adapters.in.web.controllers.dtos.request.RegisterUserRequest;
import com.sirafonso.e_library_users.core.ports.in.LoginUserInputPort;
import com.sirafonso.e_library_users.core.ports.in.RegisterUserInputPort;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final RegisterUserInputPort registerUserUsecase;
    private final LoginUserInputPort loginUserInputPort;

    public AuthController(
        RegisterUserInputPort registerUserUsecase,
        LoginUserInputPort loginUserInputPort
    ) {
        this.registerUserUsecase = registerUserUsecase;
        this.loginUserInputPort = loginUserInputPort;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        System.out.println(registerUserRequest);
        return this.registerUserUsecase.execute(registerUserRequest.toUserModelIn());
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        return this.loginUserInputPort.execute(loginUserRequest.email(), loginUserRequest.password());
    }

}
