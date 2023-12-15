package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Data
public class RegisterDto {
    @Min(value = 4, message = "minLength: 4")
    @Max(value = 32, message = "maxLength: 32")
    private String username;
    @Min(value = 8, message = "minLength: 8")
    @Max(value = 16, message = "maxLength: 16")
    private String password;
    @Min(value = 2, message = "minLength: 2")
    @Max(value = 16, message = "maxLength: 16")
    private String firstName;
    @Min(value = 2, message = "minLength: 2")
    @Max(value = 16, message = "maxLength: 16")
    private String lastName;
    @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
    private String phone;

    private Role role;

    public RegisterDto() {
    }
    public RegisterDto(String username, String password, String firstName, String lastName, String phone, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }
}
