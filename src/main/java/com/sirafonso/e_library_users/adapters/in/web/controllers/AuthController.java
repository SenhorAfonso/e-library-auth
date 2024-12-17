package com.sirafonso.e_library_users.adapters.in.web.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.sirafonso.e_library_users.adapters.in.web.controllers.dtos.request.LoginUserRequest;
import com.sirafonso.e_library_users.adapters.in.web.controllers.dtos.request.RegisterUserRequest;
import com.sirafonso.e_library_users.core.domain.dtos.response.ResponseBody;
import com.sirafonso.e_library_users.core.ports.in.LoginUserInputPort;
import com.sirafonso.e_library_users.core.ports.in.RegisterUserInputPort;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

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
    public ResponseEntity<ResponseBody> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) throws Exception {
        ResponseBody result = this.registerUserUsecase.execute(registerUserRequest.toUserModelIn());
        return ResponseEntity.status(result.status()).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseBody> loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        String result = this.loginUserInputPort.execute(loginUserRequest.email(), loginUserRequest.password());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseBody(HttpStatus.OK.value(), result));
    }

}
