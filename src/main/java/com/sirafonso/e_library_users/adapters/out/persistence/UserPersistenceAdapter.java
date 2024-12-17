package com.sirafonso.e_library_users.adapters.out.persistence;

import com.sirafonso.e_library_users.adapters.out.repository.UserEntityRepository;
import com.sirafonso.e_library_users.adapters.out.repository.entities.UserEntity;
import com.sirafonso.e_library_users.core.ports.out.persistence.UserPersistenceOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter implements UserPersistenceOutputPort {
    private final UserEntityRepository userRepository;

    @Autowired
    public UserPersistenceAdapter(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
