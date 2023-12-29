package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

import java.io.IOException;

/**
 * Интерфейс содержит методы для работы с пользователями
 */
public interface UserService {

    /**
     * Метод меняет пароль для входа в аккаунт
     * @param newPasswordDto - DTO, содержащий старый и новый пароли
     */
    void setPassword(NewPasswordDto newPasswordDto, Authentication authentication);

    /**
     * Метод для получения информации об авторизованном пользователе
     * @param username - объект класса String, содержащий имя пользователя
     * @return объект класса UserDto, содержащий все данные о пользователе
     */
    UserDto getInfo(String username);

    /**
     * Метод для изменения данных пользователя
     * @param updateUser - DTO, содержащий имя, фамилию и телефон пользователя
     * @param authentication - объект класса Authentication, содержащий данные о текущей сессии
     * @return объект класса
     */
    UpdateUserDto updateUser(UpdateUserDto updateUser, Authentication authentication);

    /**
     * Метод ищет пользователя по id
     * @param userId - объект класса String, содержащий идентификатор пользователя
     * @return объект класса UserDto, содержащий все данные о пользователе
     */
    UserDto findById(Integer userId);

    /**
     * Метод обновляет аватар пользователя
     * @param multipartFile - файл новой картинки
     * @param authentication - параметр, позволяющий работать с данными авторизованного пользователя
     */
    void patchImage(MultipartFile multipartFile, Authentication authentication) throws IOException;
}
