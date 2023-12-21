package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrUpdateCommentDto {
    @Size(min = 8, max = 64)
    private String text;
}
