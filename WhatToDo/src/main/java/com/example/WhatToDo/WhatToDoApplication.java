package com.example.WhatToDo;

import com.example.WhatToDo.Service.ChatService;
import com.example.WhatToDo.Service.MessageService;
import com.example.WhatToDo.Service.UserService;
import com.example.WhatToDo.entities.Chat;
import com.example.WhatToDo.entities.Message;
import com.example.WhatToDo.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class WhatToDoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatToDoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MessageService messageService) {
        return (args) -> {
            Message message1 = new Message(LocalDateTime.now(),"Cia raso User1");
            Message message2 = new Message(LocalDateTime.now(), "Cia raso User2");
            User user1 = new User("Rokas", "Moksliukas", LocalDate.now(), "Mok", "Vilnius", "sdf");
            User user2 = new User("Kristupas", "Moksliukas", LocalDate.now(), "MOks", "Vilnius", "af");
            Chat chat = new Chat();

            message1.addUser(user1);
            message2.addUser(user2);
            message1.addChat(chat);
            message2.addChat(chat);
            chat.addUser(user1);
            chat.addUser(user2);

            messageService.createMessage(message2);
            messageService.createMessage(message1);
        };
    }
}
