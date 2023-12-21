package ru.skypro.homework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue()
    @Column(name = "idcomment")
    private Integer id;
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
    @JoinColumn(name = "adid")
    private Ad ad;

//    public Ad getAd() {
//        return ad;
//    }
//
//    public void setAd(Ad adId) {
//        this.ad = adId;
//    }

//    public Comment() {
//    }

//    public Comment(Integer id, Integer author, String authorImage, String authorFirstName, Long createdAt, String text) {
//        this.id = id;
//        this.author = author;
//        this.authorImage = authorImage;
//        this.authorFirstName = authorFirstName;
//        this.createdAt = createdAt;
//        this.text = text;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Integer author) {
//        this.author = author;
//    }
//
//    public String getAuthorImage() {
//        return authorImage;
//    }
//
//    public void setAuthorImage(String authorImage) {
//        this.authorImage = authorImage;
//    }
//
//    public String getAuthorFirstName() {
//        return authorFirstName;
//    }
//
//    public void setAuthorFirstName(String authorFirstName) {
//        this.authorFirstName = authorFirstName;
//    }
//
//    public Long getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Long createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(author, comment.author) && Objects.equals(authorImage, comment.authorImage) && Objects.equals(authorFirstName, comment.authorFirstName) && Objects.equals(createdAt, comment.createdAt) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, authorImage, authorFirstName, createdAt, text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author=" + author +
                ", authorImage='" + authorImage + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                '}';
    }
}
