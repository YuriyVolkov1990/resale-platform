package ru.skypro.homework.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private Integer authorId;
    private String authorImage;
    private String authorFirstName;
    private Long createdAt;
    private Integer pk;
    private String text;

//    public CommentDto() {
//    }

//    public CommentDto(Integer authorId, String authorImage, String authorFirstName, Long createdAt, Integer pk, String text) {
//        this.authorId = authorId;
//        this.authorImage = authorImage;
//        this.authorFirstName = authorFirstName;
//        this.createdAt = createdAt;
//        this.pk = pk;
//        this.text = text;
//    }
//
//    public Integer getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(Integer authorId) {
//        this.authorId = authorId;
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
//    public Integer getPk() {
//        return pk;
//    }
//
//    public void setPk(Integer pk) {
//        this.pk = pk;
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
