package com.example.WhatToDo.Service;

import com.example.WhatToDo.entities.Chat;
import com.example.WhatToDo.entities.User;
import com.example.WhatToDo.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> findAllChatsByUserId(Long id) {
        List<Chat> chats = chatRepository.findAll();
        List<Chat> filterChats = new ArrayList<>();
        for (Chat chat : chats) {
            List<User> users = chat.getUsers();
            List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());
            if (userIds.contains(id)) {
                filterChats.add(chat);
            }
        }
        return filterChats;
    }

    public Chat findById(Long id) {
        return chatRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat not found"));
    }

    public void createChat(Chat chat) {
        chatRepository.save(chat);
    }

    public void deleteChat(Long id) {
        Chat chat = chatRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat not found"));
        chatRepository.deleteById(chat.getId());
    }
}
