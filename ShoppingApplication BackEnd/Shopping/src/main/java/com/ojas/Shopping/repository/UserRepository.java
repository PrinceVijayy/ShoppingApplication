package com.ojas.Shopping.repository;

import com.ojas.Shopping.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserName(String userName);
}
