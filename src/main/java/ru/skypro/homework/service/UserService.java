package ru.skypro.homework.service;

import ru.skypro.homework.dto.NewPasswordDto;

public interface UserService {
    boolean setPassword(NewPasswordDto newPasswordDto);
}
