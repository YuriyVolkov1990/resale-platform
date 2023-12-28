package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByPassword(String password);

    User findByEmail(String email);
}
