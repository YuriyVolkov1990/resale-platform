package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Интерфейс содержит методы для работы с изображениями
 */
public interface ImageService {

    /**
     * Метод получает изображение из репозитория
     *
     * @param id - идентификатор изображения
     * @return массив byte
     */
    byte[] getImage(Integer id);

    /**
     * Метод добавляет изображение к объявлению
     *
     * @param adId - идентификатор объявления
     * @param image - MultipartFile файл, содержащий изображение
     * @return строку с URL для доступа к файлу
     */
    String uploadImageToAd (Integer adId, MultipartFile image) throws IOException;

    /**
     * Метод обновляет аватар пользователя
     *
     * @param image - MultipartFile файл, содержащий изображение
     * @param authentication - объект класса Authentication, содержащий данные об авторизованном пользователе
     */
    void uploadImageToUser (MultipartFile image, Authentication authentication) throws IOException;
}
