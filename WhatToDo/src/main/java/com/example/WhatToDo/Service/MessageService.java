package com.example.WhatToDo.Service;

import com.example.WhatToDo.entities.Message;
import com.example.WhatToDo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findAllMessageByChatId(Long id) {
//        List<Message> filterMessages = new ArrayList<>();
//        for (Message message : messages) {
//            if (message.getChat().getId().equals(id)) {
//                filterMessages.add(message);
//            }
//        }
//        return filterMessages;
        return messageRepository.findAll()
                .stream()
                .filter(message -> message.getChat().getId().equals(id))
                .collect(Collectors.toList());
    }

    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        messageRepository.deleteById(message.getId());
    }
}
