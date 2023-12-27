package ru.skypro.homework.dto;

import lombok.*;
import ru.skypro.homework.entity.Comment;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private Integer count;
    private List<Comment> results;
}
