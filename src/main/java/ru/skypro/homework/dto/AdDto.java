package ru.skypro.homework.dto;

import liquibase.pro.packaged.S;
import lombok.Data;

@Data
public class AdDto {
    private Integer author;
    private String image;
    private Long id;
    private Integer price;
    private String title;

    public AdDto() {
    }

    public AdDto(Integer author, String image, Long id, Integer price, String title) {
        this.author = author;
        this.image = image;
        this.id = id;
        this.price = price;
        this.title = title;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
