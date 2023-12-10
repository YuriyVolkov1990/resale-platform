package ru.skypro.homework.service.impl;

import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDetailsManager userDetailsManager;
    public UserServiceImpl(UserRepository userRepository, UserDetailsManager userDetailsManager) {
        this.userRepository = userRepository;
        this.userDetailsManager = userDetailsManager;
    }
    @Override
    public String setPassword(NewPasswordDto newPasswordDto) {
        User existingUser = userRepository.findByPassword(newPasswordDto.getCurrentPassword());
        userDetailsManager.changePassword(newPasswordDto.getCurrentPassword(), newPasswordDto.getNewPassword());
        return existingUser.getPassword();
    }

}
