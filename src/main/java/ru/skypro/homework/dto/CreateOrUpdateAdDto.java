package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateOrUpdateAdDto {
    @Min(value = 4, message = "minLength: 8")
    @Max(value = 32, message = "maxLength: 16")
    private String title;
    @Min(value = 0, message = "minimum: 0")
    @Max(value = 10000000, message = "maximum: 10000000")
    private Integer price;
    @Min(value = 8, message = "minLength: 8")
    @Max(value = 64, message = "maxLength: 64")
    private String description;

    public CreateOrUpdateAdDto() {
    }

    public CreateOrUpdateAdDto(String title, Integer price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
