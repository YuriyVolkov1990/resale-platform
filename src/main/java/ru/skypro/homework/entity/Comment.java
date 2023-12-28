package ru.skypro.homework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
/**
 * Класс, описывающий сущность Comment
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue()
    @Column(name = "idcomment")
    private Integer pk;
    @Column(name = "iduser")
    private Integer author;
    @Column(name = "authorimage")
    private String authorImage;
    @Column(name = "authorfirstname")
    private String authorFirstName;
    @Column(name = "createdat")
    private Long createdAt;
    @Column(name = "message")
    private String text;
    @ManyToOne
    @JoinColumn(name = "ad")
    private Ad ad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(pk, comment.pk) && Objects.equals(author, comment.author) && Objects.equals(authorImage, comment.authorImage) && Objects.equals(authorFirstName, comment.authorFirstName) && Objects.equals(createdAt, comment.createdAt) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, author, authorImage, authorFirstName, createdAt, text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "pk=" + pk +
                ", author=" + author +
                ", authorImage='" + authorImage + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                '}';
    }
}
