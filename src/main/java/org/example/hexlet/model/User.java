package org.example.hexlet.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
