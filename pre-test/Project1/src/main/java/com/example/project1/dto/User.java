package com.example.project1.dto;

import jakarta.validation.constraints.NotEmpty;

public class User {
    @NotEmpty
    private String name;
    @NotEmpty
    private String message;

    public User(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
