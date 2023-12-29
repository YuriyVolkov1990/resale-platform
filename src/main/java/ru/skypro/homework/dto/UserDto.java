package ru.skypro.homework.dto;

import lombok.*;
/**
 * Класс, описывающий Data Transfer Object для передачи информации о title, price, description
 */
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
