package com.example.WhatToDo.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String nickName;
    private String location;
    private String moreInfo;

    @OneToMany
    private List<Message> messages;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Chat>chats;

    public User(String name, String surname, LocalDate birthday, String nickName, String location, String moreInfo) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.nickName = nickName;
        this.location = location;
        this.moreInfo = moreInfo;
    }
}
