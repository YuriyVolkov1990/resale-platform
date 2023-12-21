package ru.skypro.homework.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Data
public class CreateOrUpdateCommentDto {
    @Size(min = 8, max = 64)
    private String text;
//    public CreateOrUpdateCommentDto() {
//    }
//    public CreateOrUpdateCommentDto(String text) {
//        this.text = text;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
}
