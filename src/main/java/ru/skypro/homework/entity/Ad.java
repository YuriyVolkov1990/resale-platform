package ru.skypro.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
/**
 * Класс, описывающий сущность Ad
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "ad")
    @JsonIgnore
    private List<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image imageId;
}
