package ru.skypro.homework.dto;

public class CreateOrUpdateCommentDto {
    private String text;
    public CreateOrUpdateCommentDto() {
    }
    public CreateOrUpdateCommentDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
