package ru.skypro.homework.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdsDto {

    private List<AdDto> results;
    private Integer count;
}

