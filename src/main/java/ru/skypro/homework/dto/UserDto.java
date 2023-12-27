package ru.skypro.homework.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer pk;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private String image;
}
