package com.example.WhatToDo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
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

    @JsonIgnore
    @OneToMany
    private List<Message> messages = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Chat> chats = new ArrayList<>();

    public User(String name, String surname, LocalDate birthday, String nickName, String location, String moreInfo) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.nickName = nickName;
        this.location = location;
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
