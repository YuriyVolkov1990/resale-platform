package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;

import java.util.Optional;

/**
 * Класс-репозиторий для взаимодействия с массивом объектов класса Image
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findFirstByAd(Ad ad);
    Optional<Image> findFirstByUser(User user);
}
