package com.sirafonso.e_library_users.core.ports.out.persistence;

import com.sirafonso.e_library_users.adapters.out.repository.entities.UserEntity;

public interface UserPersistenceOutputPort {
    UserEntity findByUsername(String username);
}
