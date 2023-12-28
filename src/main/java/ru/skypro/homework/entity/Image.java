package ru.skypro.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
/**
 * Класс, описывающий сущность Image
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String path;

    private long fileSize;

    private String mediaType;

    private byte[] data;
    @OneToMany(mappedBy = "imageId")
    private List<Ad> ad;
    @OneToMany(mappedBy = "imageId")
    private List<User> user;
}
