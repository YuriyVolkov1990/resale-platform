package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;

import java.util.List;

/**
 * Класс-репозиторий для взаимодействия с массивом объектов класса Ad
 */
public interface AdsRepository extends JpaRepository<Ad, Integer> {
    Ad findAdByPk(Integer pk);

    List<Ad> findAdByUser(User user);

}
