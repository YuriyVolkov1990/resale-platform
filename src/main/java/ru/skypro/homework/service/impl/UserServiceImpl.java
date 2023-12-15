package ru.skypro.homework.service.impl;

import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserDetailsManager manager;
    private UserRepository userRepository;
    public UserServiceImpl(UserMapper userMapper, UserDetailsManager manager, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.manager = manager;
        this.userRepository = userRepository;
    }
    @Override
    public void setPassword(NewPasswordDto newPasswordDto) {
        manager.changePassword(newPasswordDto.getCurrentPassword(), newPasswordDto.getNewPassword());
// метод void, можно отсавить только changePassword, ничего не возвращать
    }

    @Override
    public UserDto getInfo() {
//        UserDto// достать юзера из юзердетаилс и вернуть
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
