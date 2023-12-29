package ru.skypro.homework.dto;

import lombok.*;
/**
 * Класс, описывающий Data Transfer Object для передачи расширенного блока информации об объекте Ad
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtendedAdDto {
    private Integer pk;
    private String authorFirstName;
    private String authorLastName;
    private String description;
    private String email;
    private String image;
    private String phone;
    private Integer price;
    private String title;
}
