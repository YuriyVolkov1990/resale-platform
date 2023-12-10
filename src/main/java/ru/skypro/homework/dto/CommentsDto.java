package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.entity.Comment;
@Data
public class CommentsDto {
    private Integer count;
    private Comment results;

    public CommentsDto() {
    }

    public CommentsDto(Integer count, Comment results) {
        this.count = count;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Comment getResults() {
        return results;
    }

    public void setResults(Comment results) {
        this.results = results;
    }
}
