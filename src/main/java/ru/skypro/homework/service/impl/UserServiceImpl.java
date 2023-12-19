package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.PassNotMatchException;
//import ru.skypro.homework.manager.MyUserDetailsManager;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
//    private final MyUserDetailsManager manager;
    private final PasswordEncoder encoder;
    private UserRepository userRepository;
    private ImageRepository imageRepository;
    public UserServiceImpl(UserMapper userMapper, /*MyUserDetailsManager manager,*/ PasswordEncoder encoder, UserRepository userRepository) {
        this.userMapper = userMapper;
//        this.manager = manager;
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public void setPassword(NewPasswordDto newPasswordDto) {
//        manager.changePassword(newPasswordDto.getCurrentPassword(), newPasswordDto.getNewPassword());
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

    @Override
    public void updateUserImage(MultipartFile image, Authentication authentication) throws IOException {
//        UserDetails user = userRepository.findUserByEmail(authentication.getName());
//        Image newImage = imageRepository.
    }

    public UserDto findByPassword(String password) {
        return null;
    }// как в домашке про хогвартс

}
