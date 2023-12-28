package ru.skypro.homework.mapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;

@Component
@Data
@RequiredArgsConstructor
public class UserMapper {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setPk(user.getPk());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setImage(user.getImage());
        return dto;
    }

    public User mapToUser(UserDto dto) {
        User user = new User();
        user.setPk(dto.getPk());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
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

    public User mapFromUpdateUserDtoToUser(UpdateUserDto dto, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        return user;
    }

    public UpdateUserDto mapFromUserToUpdateUserDto(User user) {
        UpdateUserDto dto = new UpdateUserDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public RegisterDto mapFromUserToRegisterDto(User user) {
        RegisterDto dto = new RegisterDto();
        dto.setUsername(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }

    public User mapFromRegisterDtoToUser(RegisterDto dto) {
        User user = new User();
        user.setEmail(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;
    }
}
