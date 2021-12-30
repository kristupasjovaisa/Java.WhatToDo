package com.example.WhatToDo.controller;

import com.example.WhatToDo.Service.ChatService;
import com.example.WhatToDo.entities.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class ChatController {

    @Autowired
   private ChatService chatService;

    @RequestMapping("/chats/{id}")
    public List<Chat> findAllChats(@PathVariable Long id){
        return chatService.findAllChatsByUserId(id);
    }
}
