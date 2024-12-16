package com.sirafonso.e_library_users.config;

import com.sirafonso.e_library_users.core.ports.in.LoginUserInputPort;
import com.sirafonso.e_library_users.core.ports.in.RegisterUserInputPort;
import com.sirafonso.e_library_users.core.usecases.LoginUserUsecase;
import com.sirafonso.e_library_users.core.usecases.RegisterUserUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputPortInjection {

    @Bean
    public RegisterUserInputPort registerUser() {
        return new RegisterUserUsecase();
    }

    @Bean
    LoginUserInputPort loginUser() {
        return new LoginUserUsecase();
    }

}
