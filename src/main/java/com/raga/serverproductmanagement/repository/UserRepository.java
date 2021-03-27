package com.raga.serverproductmanagement.repository;

import com.raga.serverproductmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    //findBy + fieldName
    Optional<User> findByUsername (String username);
}
