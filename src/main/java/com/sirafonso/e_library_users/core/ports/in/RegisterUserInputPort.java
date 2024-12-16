package com.sirafonso.e_library_users.core.ports.in;

import com.sirafonso.e_library_users.core.domain.models.UserModelIn;

public interface RegisterUserInputPort {
    String execute(UserModelIn newUser);
}
