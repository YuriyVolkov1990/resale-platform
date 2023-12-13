package ru.skypro.homework.service;

import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

public interface UserService {
    public NewPasswordDto postPassword(NewPasswordDto newPasswordDto);

    public UserDto getInfo();

    public UpdateUserDto updateUser();
}
