package ru.skypro.homework.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.UUID;
@Service
public class ImageServiceImp implements ImageService {
    private final ImageRepository imageRepository;
    private final UserMapper userMapper;
    @Value("${path.to.avatars.folder}")
    private Path imagePath;
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

    @Override
    public Image uploadImage(Integer id, MultipartFile image) throws IOException {
        Files.createDirectories(imagePath);
        int dotIndex = image.getOriginalFilename().lastIndexOf(".");
        String fileExtension = image.getOriginalFilename().substring(dotIndex + 1);
        Path filePath = imagePath.resolve(id + "." + fileExtension);
        byte[] data = image.getBytes();
        Files.write(filePath, data, StandardOpenOption.CREATE);
        Image newImage = userMapper.mapMultipartFileToImage(image);
        imageRepository.save(newImage);
        return newImage;
    }
}
