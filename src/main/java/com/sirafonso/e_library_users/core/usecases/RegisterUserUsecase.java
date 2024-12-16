package com.sirafonso.e_library_users.core.usecases;

import com.sirafonso.e_library_users.core.domain.models.UserModelIn;
import com.sirafonso.e_library_users.core.ports.in.RegisterUserInputPort;

public class RegisterUserUsecase implements RegisterUserInputPort {

    @Override
    public String execute(UserModelIn newUser) {
        return "registering user";
    }
}
