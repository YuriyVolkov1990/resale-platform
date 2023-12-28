package ru.skypro.homework.dto;

import lombok.*;
/**
 * Класс, описывающий Data Transfer Object для сущности Comment
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Integer authorId;
    private String authorImage;
    private String authorFirstName;
    private Long createdAt;
    private Integer pk;
    private String text;
}
