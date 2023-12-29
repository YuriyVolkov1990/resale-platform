package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * Класс, описывающий Data Transfer Object для обновления информации о пользователе
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    @Size(min = 3, max = 10)
    private String firstName;
    @Size(min = 3, max = 10)
    private String lastName;
    @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
    private String phone;
}
