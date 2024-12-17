package com.sirafonso.e_library_users.core.usecases;

import com.sirafonso.e_library_users.core.ports.in.LoginUserInputPort;

public class LoginUserUsecase implements LoginUserInputPort {
    @Override
    public String execute(String email, String password) {
        return "loggin user";
    }
}
