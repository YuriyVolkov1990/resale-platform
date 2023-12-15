package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateOrUpdateCommentDto {
    @Min(value = 8, message = "minLength: 8")
    @Max(value = 64, message = "maxLength: 64")
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
