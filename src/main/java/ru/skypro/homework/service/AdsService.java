package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;

import java.io.IOException;
import java.util.Optional;
/**
 * Интерфейс содержит методы для работы с объявлениями
 */
public interface AdsService {

    /**
     * Метод возвращает список всех объявлений в виде DTO {@link Ad}.
     *
     * @return возвращает все объявления из БД в виде AdsDto
     */
    AdsDto getAllAds();

    /**
     * Метод добавляет новое объявление в БД
     *
     * @param properties - DTO модель класса {@link CreateOrUpdateAdDto};
     * @param image      - фотография объявления
     * @return возвращает объявление в виде AdDto
     */
    AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication) throws IOException;

    /**
     * Метод получает информацию об объявлении по id
     *
     * @param id - id объявления
     * @return возвращает ExtendedAdDto
     */
    ExtendedAdDto getInfoExtendedAd(Integer id);

    /**
     * Метод удаляет объявление по id
     *
     * @param id - id объявления
     */
    void deleteAd(Integer id);

    /**
     * Метод вносит изменения в объявление
     *
     * @param id  - id объявления
     * @param dto - DTO модель класса {@link CreateOrUpdateAdDto};
     * @return возвращает DTO модель объявления
     */
    AdDto patchAd(Integer id, CreateOrUpdateAdDto dto);

    /**
     * Метод получает все объявления данного пользователя
     *
     * @param authentication - класс, позволяющий работать с параметрами авторизованного пользователя
     * @return возвращает список объявлений пользователя в виде AdsDto
     */
    AdsDto getUserAds(Authentication authentication);

    /**
     * Метод меняет картинку в объявлении
     *
     * @param id - идентификатор картинки в базе
     * @param multipartFile - файл новой картинки
     * @return возвращает путь к файлу
     */
    String patchImage(Integer id, MultipartFile multipartFile) throws IOException;

    /**
     * Метод ищет объявление по id
     *
     * @param id - идентификатор объявления в базе
     * @return возвращает Optional<Ad>
     */
    Optional<Ad> findById(Integer id);

}
