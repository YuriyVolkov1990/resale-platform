package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
@Service
public class ImageServiceImp implements ImageService {
    private final ImageRepository imageRepository;
    private final UserMapper userMapper;

    public ImageServiceImp(ImageRepository imageRepository, UserMapper userMapper) {
        this.imageRepository = imageRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Image createImage(MultipartFile image) {
        Image newImage = new Image();
        try {
            byte[] bytes = image.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newImage.setId(Integer.valueOf(UUID.randomUUID().toString()));
        return imageRepository.saveAndFlush(newImage);
    }

    @Override
    public Image updateImage(MultipartFile newImage, Image image) {
        try {
            byte[] bytes = newImage.getBytes();
            image.setData(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageRepository.saveAndFlush(image);
    }

    @Override
    public byte[] getImage(Integer id) {
        Optional<Image> image = imageRepository.findById(id);
        return image.get().getData();
    }
}
