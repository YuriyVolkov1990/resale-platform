package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Size;
/**
 * Класс, описывающий Data Transfer Object для передачи информации о title, price, description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateCommentDto {
    @Size(min = 8, max = 64)
    private String text;
}
