package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ad, Integer> {
    Ad findAdByPk(Integer pk);

    List<Ad> findAdByUser(User user);

    Ad getAdByPk(Integer adId);

    Ad findFirstById(Integer adId);
}
