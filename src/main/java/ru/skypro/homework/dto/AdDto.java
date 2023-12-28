package ru.skypro.homework.dto;

import lombok.*;

/**
 * Класс, описывающий Data Transfer Object для сущности Ad
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdDto {
    private Integer author;
    private String image;
    private Integer pk;
    private Integer price;
    private String title;
}
