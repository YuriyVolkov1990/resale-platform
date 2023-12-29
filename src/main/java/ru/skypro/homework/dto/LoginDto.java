package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Size;
/**
 * Класс, описывающий Data Transfer Object для передачи информации об username и password
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @Size(min = 8, max = 16)
    private String username;
    @Size(min = 4, max = 32)
    private String password;
}
