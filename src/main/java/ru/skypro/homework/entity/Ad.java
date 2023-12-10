package ru.skypro.homework.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer author;
    private String image;
    private Integer price;
    private String title;
    public Ad(Long id, Integer author, String image, Integer price, String title) {
        this.id = id;
        this.author = author;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ads = (Ad) o;
        return Objects.equals(id, ads.id) && Objects.equals(author, ads.author) && Objects.equals(image, ads.image) && Objects.equals(price, ads.price) && Objects.equals(title, ads.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, image, price, title);
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", author=" + author +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

}
