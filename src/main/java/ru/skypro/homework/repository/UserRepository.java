package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.User;

/**
 * Класс-репозиторий для взаимодействия с массивом объектов класса User
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
