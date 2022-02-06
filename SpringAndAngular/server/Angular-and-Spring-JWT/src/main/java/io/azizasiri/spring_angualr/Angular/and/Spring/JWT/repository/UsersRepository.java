package io.azizasiri.spring_angualr.Angular.and.Spring.JWT.repository;

import io.azizasiri.spring_angualr.Angular.and.Spring.JWT.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


// This repo is for User Table
public interface UsersRepository extends JpaRepository<User, Long> {
    // This method to return a user
    User findUserByUsername(String usrname);
    User findUSerByEmail(String email);
}
