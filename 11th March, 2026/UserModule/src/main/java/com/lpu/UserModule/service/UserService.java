package com.lpu.UserModule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.UserModule.entity.UserEntity;
import com.lpu.UserModule.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }
}