package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

import java.io.IOException;

public interface UserService {
    void setPassword(NewPasswordDto newPasswordDto);

    UserDto getInfo(String username);

    UpdateUserDto updateUser(UpdateUserDto updateUser, Authentication authentication);

    UserDto findById(Integer userId);

    void updateUserImage(MultipartFile image, Authentication authentication) throws IOException;
}
