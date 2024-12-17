package com.sirafonso.e_library_users.core.ports.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sirafonso.e_library_users.core.domain.dtos.response.ResponseBody;
import com.sirafonso.e_library_users.core.domain.models.UserModelIn;

import java.util.Map;

public interface RegisterUserInputPort {
    ResponseBody execute(UserModelIn newUser) throws Exception;
}
