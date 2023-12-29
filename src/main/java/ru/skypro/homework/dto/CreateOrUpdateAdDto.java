package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
/**
 * Класс, описывающий Data Transfer Object для передачи информации о title, price, description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateAdDto {
    @Size(min = 4, max = 32)
    private String title;
    @Min(value = 0, message = "minimum: 0")
    @Max(value = 10000000, message = "maximum: 10000000")
    private Integer price;
    @Size(min = 8, max = 64)
    private String description;
}
