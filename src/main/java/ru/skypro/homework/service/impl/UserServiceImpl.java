package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.PassNotMatchException;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;
    private UserRepository userRepository;
    public UserServiceImpl(UserMapper userMapper, UserDetailsManager manager, PasswordEncoder encoder, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.manager = manager;
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public void setPassword(NewPasswordDto newPasswordDto) {

    }

    @Override
    public UserDto getInfo(String s) {

        return null;
    }

    @Override
    public UpdateUserDto updateUser() {
        return null;
    }//достать юзера из сессии и обновить

    @Override
    public UserDto findById(Integer userId) {
        return null;
    }

    public UserDto findByPassword(String password) {
        return null;
    }// как в домашке про хогвартс

}
