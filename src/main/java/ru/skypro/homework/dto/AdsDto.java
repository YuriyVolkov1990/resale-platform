package ru.skypro.homework.dto;

import lombok.*;

import java.util.List;
/**
 * Класс, описывающий Data Transfer Object для списка AdDto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdsDto {

    private List<AdDto> results;
    private Integer count;
}

