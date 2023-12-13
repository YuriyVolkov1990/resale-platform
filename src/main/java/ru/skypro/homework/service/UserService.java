package ru.skypro.homework.service;

import ru.skypro.homework.dto.NewPasswordDto;

public interface UserService {
    public NewPasswordDto setPassword(NewPasswordDto newPasswordDto);
}
