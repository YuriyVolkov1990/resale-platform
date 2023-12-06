package ru.skypro.homework.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
public class UserDto {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private RoleDto role;
    private String image;
}
