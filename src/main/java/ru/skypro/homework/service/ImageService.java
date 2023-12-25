package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;

import java.io.IOException;

/**
 * Интерфейс содержит методы для работы с изображениями
 */
public interface ImageService {

    /**
     * Метод сохраняет изображение в репозитории
     * @param image - MultipartFile файл, содержащий изображение
     * @return объект класса Image
     */
    Image createImage(MultipartFile image);

    /**
     * Метод обновляет изображение в репозитории
     * @param newImage - MultipartFile файл, содержащий новое изображение
     * @param oldImage - MultipartFile файл, содержащий старое изображение
     * @return объект класса Image
     */
    Image updateImage(MultipartFile newImage, Image oldImage);

    /**
     * Метод получает изображение из репозитория
     * @param id - идентификатор изображения
     * @return массив byte???????
     */
    Image getImage(Integer id);


    /**
     * Метод добавляет изображение к объявлению
     * @param adId - идентификатор объявления
     * @param image - MultipartFile файл, содержащий изображение
     * @return строковое представление массива байтов, хранящих информацию об изображении
     */
    String uploadImageToAd (Integer adId, MultipartFile image) throws IOException;

    //    /**
//     * Метод обновляет аватар пользователя
//     * @param image - MultipartFile файл, содержащий изображение
//     * @param authentication - объект класса Authentication, содержащий данные о текущей сессии
//     */
//    void uploadImageToUser (MultipartFile image, Authentication authentication) throws IOException;
}
