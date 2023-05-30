package com.myaccessweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myaccessweb.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
