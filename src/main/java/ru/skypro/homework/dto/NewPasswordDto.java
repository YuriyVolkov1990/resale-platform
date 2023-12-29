package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Size;
/**
 * Класс, описывающий Data Transfer Object для передачи информации о title, price, description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPasswordDto {
    @Size(min = 8, max = 16)
    private String currentPassword;
    @Size(min = 8, max = 16)
    private String newPassword;
}
