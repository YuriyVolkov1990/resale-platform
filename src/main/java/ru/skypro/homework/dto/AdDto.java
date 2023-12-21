package ru.skypro.homework.dto;

import lombok.*;

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
