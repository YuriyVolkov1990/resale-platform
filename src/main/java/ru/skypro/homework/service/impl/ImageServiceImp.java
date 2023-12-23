package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ImageServiceImp implements ImageService {
    private final ImageRepository imageRepository;
    private final UserMapper userMapper;
    private final AdsRepository adsRepository;
    @Value("${path.to.images.folder}")
    private Path imagePath;
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
    public String uploadImageToAd(Integer adId, MultipartFile image) throws IOException {
        Files.createDirectories(imagePath);
        int dotIndex = image.getOriginalFilename().lastIndexOf(".");
        String fileExtension = image.getOriginalFilename().substring(dotIndex + 1);
        Path filePath = imagePath.resolve(adId + "." + fileExtension);
        byte[] data = image.getBytes();
        Files.write(filePath, data, StandardOpenOption.CREATE);
        Ad ad = adsRepository.findAdByPk(adId);
        Image newImage = imageRepository.findFirstByAd(ad).orElse(new Image());
        ad.setImage(newImage.getPath());
        newImage.setMediaType(image.getContentType());
        newImage.setFileSize(image.getSize());
        newImage.setData(data);
        newImage.setPath(filePath.toAbsolutePath().toString());
        newImage.setAd(ad);
        imageRepository.save(newImage);
        return Arrays.toString(image.getBytes());
    }
//    private String getExtensions(String fileName) {
//        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
//    @Override
//    public Image uploadImage(Integer id, MultipartFile image) throws IOException {
//        getImagePath(id, image);
//        Image newImage = userMapper.mapMultipartFileToImage(image);
//        imageRepository.save(newImage);
//        return newImage;
//    }
//
//    public void getImagePath(Integer id, MultipartFile image) throws IOException {
//        Files.createDirectories(imagePath);
//        int dotIndex = image.getOriginalFilename().lastIndexOf(".");
//        String fileExtension = image.getOriginalFilename().substring(dotIndex + 1);
//        Path filePath = imagePath.resolve(id + "." + fileExtension);
//        byte[] data = image.getBytes();
//        Files.write(filePath, data, StandardOpenOption.CREATE);
//    }



//
//        System.out.println("---------------------");
//                System.out.println("image.getOriginalFilename() = " + image.getOriginalFilename());
//                System.out.println("---------------------");
//                System.out.println("=====================");
//                System.out.println("filePath = " + filePath);
//                System.out.println("=====================");
//                Files.createDirectories(filePath.getParent());
//                System.out.println("+++++++++++++++++++++");
//                System.out.println("filePath.getParent() = " + filePath.getParent());
//                System.out.println("+++++++++++++++++++++");



//    Image newImage = userMapper.mapMultipartFileToImage(image);
//    Ad ad = adsRepository.getAdByPk(adId);
//    Path filePath = imagePath.resolve(newImage.getId() + "." + getExtensions(Objects.requireNonNull(image.getOriginalFilename())));
//        Files.deleteIfExists(filePath);
//        try (
//    InputStream is = image.getInputStream();
//    OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
//    BufferedInputStream bis = new BufferedInputStream(is, 1024);
//    BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
//        ) {
//        bis.transferTo(bos);
//    }
//        imageRepository.save(newImage);
//        ad.setImage(Arrays.toString(newImage.getData()));
//        Files.createDirectories(filePath.getParent());
//        return Arrays.toString(newImage.getData());
