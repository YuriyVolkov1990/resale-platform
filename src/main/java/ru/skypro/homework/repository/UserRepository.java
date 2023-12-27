package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skypro.homework.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByPassword(String password);

    UserDetails findUserDetailsByEmail(String email);

    User findByEmail(String email);
}
