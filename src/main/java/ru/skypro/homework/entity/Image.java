package ru.skypro.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "path")
    private String path;
    @Column(name = "filesize")
    private long fileSize;
    @Column(name = "mediatype")
    private String mediaType;
    @Column(name = "data")
    private byte[] data;
    @OneToMany(mappedBy = "imageId")
    private List<Ad> ad;
    @OneToMany(mappedBy = "imageId")
    private List<User> user;
}
