package ru.skypro.homework.entity;

import liquibase.license.LicenseService;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer pk;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private Integer price;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private User user;
    @OneToMany(mappedBy = "ad")
    private List<Comment> comments;

    public Ad() {
    }

    public Ad(Integer pk, String image, Integer price, String title, String description) {
        this.pk = pk;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
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
        Ad ad = (Ad) o;
        return Objects.equals(pk, ad.pk) && Objects.equals(image, ad.image) && Objects.equals(price, ad.price) && Objects.equals(title, ad.title) && Objects.equals(user, ad.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, image, price, title, user);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + pk +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", user=" + user +
                '}';
    }
}
