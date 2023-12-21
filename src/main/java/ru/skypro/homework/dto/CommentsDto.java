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

//    public CommentsDto() {
//    }
//
//    public CommentsDto(Integer count, List<Comment> results) {
//        this.count = count;
//        this.results = results;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public List<Comment> getResults() {
//        return results;
//    }
//
//    public void setResults(List<Comment> results) {
//        this.results = results;
//    }
}
