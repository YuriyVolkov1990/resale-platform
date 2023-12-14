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
    public NewPasswordDto setPassword(NewPasswordDto newPasswordDto) {
        manager.changePassword(newPasswordDto.getCurrentPassword(), newPasswordDto.getNewPassword());
        User user = userMapper.mapToNewPassword(newPasswordDto);
        return userMapper.mapToNewPasswordDto(user);
    }

    @Override
    public UserDto getInfo() {
        userRepository.flush();
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

//    public UserDto findByPassword(String password) {
//        userMapper.mapToUser( )
//    }

}
