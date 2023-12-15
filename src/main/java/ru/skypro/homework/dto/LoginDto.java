package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class LoginDto {
    @Min(value = 8, message = "minLength: 8")
    @Max(value = 16, message = "maxLength: 16")
    private String username;
    @Min(value = 4, message = "minLength: 8")
    @Max(value = 32, message = "maxLength: 16")
    private String password;
    public LoginDto() {
    }
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
