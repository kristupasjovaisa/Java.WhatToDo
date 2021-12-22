package com.example.WhatToDo.repository;

import com.example.WhatToDo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
