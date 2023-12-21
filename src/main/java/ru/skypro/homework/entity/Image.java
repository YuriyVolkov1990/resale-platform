package ru.skypro.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
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

    public Image() {
    }

//    public Image(Integer id, String path, long fileSize, String mediaType, byte[] data) {
//        this.id = id;
//        this.path = path;
//        this.fileSize = fileSize;
//        this.mediaType = mediaType;
//        this.data = data;
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public long getFileSize() {
//        return fileSize;
//    }
//
//    public void setFileSize(long fileSize) {
//        this.fileSize = fileSize;
//    }
//
//    public String getMediaType() {
//        return mediaType;
//    }
//
//    public void setMediaType(String mediaType) {
//        this.mediaType = mediaType;
//    }
//
//    public byte[] getData() {
//        return data;
//    }
//
//    public void setData(byte[] data) {
//        this.data = data;
//    }
}
