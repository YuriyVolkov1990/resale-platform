package ru.skypro.homework.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.impl.ImageServiceImp;

import java.io.IOException;

@Component
public class UserMapper {
    private final UserRepository userRepository;
    private final ImageServiceImp imageService;

    public UserMapper(UserRepository userRepository, ImageServiceImp imageService) {
        this.userRepository = userRepository;
        this.imageService = imageService;
    }

    public UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setPk(user.getPk());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }
    public User mapToUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getPk());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;
    }
    public NewPasswordDto mapToNewPasswordDto(User user) {
        NewPasswordDto dto = new NewPasswordDto();
        dto.setNewPassword(user.getPassword());
        return dto;
    }
    public User mapToNewPassword(NewPasswordDto newPasswordDto) {
       User user = userRepository.findByPassword(newPasswordDto.getCurrentPassword());
       user.setPassword(newPasswordDto.getNewPassword());
       return user;
    }
    public Image mapMultipartFileToImage(MultipartFile imageMulti) {
        Image image = new Image();
        try {
            image.setData(imageMulti.getBytes());
            image.setMediaType(imageMulti.getContentType());
            image.setFileSize(imageMulti.getSize());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
}
