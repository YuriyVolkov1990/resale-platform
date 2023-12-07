package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class LoginDto {
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
