package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;

import java.io.IOException;

public interface ImageService {
    Image createImage(MultipartFile image);

    Image updateImage(MultipartFile newImage, Image oldImage);

    byte[] getImage(Integer id);

    Image uploadImage (Integer imageId, MultipartFile image) throws IOException;
}
