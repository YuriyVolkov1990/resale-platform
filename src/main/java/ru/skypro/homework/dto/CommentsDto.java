package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.entity.Comment;
@Data
public class CommentsDto {
    private Integer count;
    private Comment results;
}
