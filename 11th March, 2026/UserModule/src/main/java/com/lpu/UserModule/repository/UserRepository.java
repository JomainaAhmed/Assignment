package com.lpu.UserModule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.UserModule.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}