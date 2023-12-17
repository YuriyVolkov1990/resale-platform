package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

public interface UserService {
    void setPassword(NewPasswordDto newPasswordDto);

    UserDto getInfo(String username);

    UpdateUserDto updateUser();

    UserDto findById(Integer userId);
}
