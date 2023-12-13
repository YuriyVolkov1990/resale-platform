package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public NewPasswordDto postPassword(NewPasswordDto newPasswordDto) {
        User user = userMapper.mapToNewPasswordDto(newPasswordDto);
        return userMapper.mapToNewPassword(user);
    }

    @Override
    public UserDto getInfo() {
        return null;
    }

    @Override
    public UpdateUserDto updateUser() {
        return null;
    }

    @Override
    public UserDto findById(Integer userId) {
        return null;
    }

}
