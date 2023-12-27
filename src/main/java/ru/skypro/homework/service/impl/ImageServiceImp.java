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
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
    private final UserRepository userRepository;
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
        newImage.setMediaType(image.getContentType());
        newImage.setFileSize(image.getSize());
        newImage.setData(data);
        newImage.setPath(filePath.toAbsolutePath().toString());
        newImage.setAd(ad);
        imageRepository.save(newImage);
        String url = "/ads/image/";
        url = url.concat(newImage.getId().toString());
        ad.setImage(url);
        return url;
    }

//    @Override
//    public void uploadImageToUser(MultipartFile image, Authentication authentication) throws IOException {
//        User user = userRepository.findByEmail(authentication.getName());
//        Files.createDirectories(imagePath);
//        int dotIndex = image.getOriginalFilename().lastIndexOf(".");
//        String fileExtension = image.getOriginalFilename().substring(dotIndex + 1);
//        Path filePath = imagePath.resolve(user.getPk() + "." + fileExtension);
//        byte[] data = image.getBytes();
//        Files.write(filePath, data, StandardOpenOption.CREATE);
//        Image newImage = imageRepository.findFirstByUser(user).orElse(new Image());
//        user.setImage(newImage.getPath());
//        newImage.setMediaType(image.getContentType());
//        newImage.setFileSize(image.getSize());
//        newImage.setData(data);
//        newImage.setPath(filePath.toAbsolutePath().toString());
//        newImage.setUser(user);
//        imageRepository.save(newImage);
//    }
}




