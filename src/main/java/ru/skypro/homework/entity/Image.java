package ru.skypro.homework.entity;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "fileSize")
    private long fileSize;
    @Column(name = "mediaType")
    private String mediaType;
    @Column(name = "data")
    private byte[] data;
}
