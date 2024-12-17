package com.sirafonso.e_library_users.core.usecases;

import com.sirafonso.e_library_users.core.domain.dtos.response.ResponseBody;
import com.sirafonso.e_library_users.core.domain.models.UserModelIn;
import com.sirafonso.e_library_users.core.ports.in.RegisterUserInputPort;
import com.sirafonso.e_library_users.core.ports.out.http.HttpRequestOutputPort;


public class RegisterUserUsecase implements RegisterUserInputPort {
    private HttpRequestOutputPort httpRequest;

    public RegisterUserUsecase(
            HttpRequestOutputPort httpRequest
    ) {
        this.httpRequest = httpRequest;
    }

    @Override
    public ResponseBody execute(UserModelIn newUser) throws Exception {
        return this.httpRequest.sendPostRequest("http://localhost:8080/users", newUser);
    }
}
