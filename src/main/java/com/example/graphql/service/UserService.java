package com.example.graphql.service;

import com.example.graphql.entity.UserEntity;
import com.example.graphql.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
    }

    public UserEntity saveUserEntity(UserEntity user){
        return userRepository.save(user);
    }
}
