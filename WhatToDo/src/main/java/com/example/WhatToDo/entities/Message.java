package com.example.WhatToDo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Message(LocalDateTime createdAt, String text) {
        this.createdAt = createdAt;
        this.text = text;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    private Chat chat;
    private String text;

    public void addUser(User user) {
        this.user = user;
        user.getMessages().add(this);
    }

    public void addChat(Chat chat) {
        this.chat = chat;
        chat.getMessages().add(this);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", chat=" + chat +
                ", text='" + text + '\'' +
                '}';
    }
}
