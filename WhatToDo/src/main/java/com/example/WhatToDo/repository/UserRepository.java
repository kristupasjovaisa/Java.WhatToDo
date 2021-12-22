package com.example.WhatToDo.repository;

import com.example.WhatToDo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
