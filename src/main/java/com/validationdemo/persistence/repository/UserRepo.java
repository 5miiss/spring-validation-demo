package com.validationdemo.persistence.repository;

import com.validationdemo.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    boolean existsByUserNameAndDeletedFalse(String userName);
    Optional<User> findByRefNoAndDeletedFalse(String refNo);
    boolean existsByEmailAndDeletedFalse(String email);



}
