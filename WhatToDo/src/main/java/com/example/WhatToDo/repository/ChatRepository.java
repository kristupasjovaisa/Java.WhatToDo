package com.example.WhatToDo.repository;

import com.example.WhatToDo.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
