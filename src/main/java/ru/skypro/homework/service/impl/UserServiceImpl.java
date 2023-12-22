package ru.skypro.homework.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.manager.MyUserDetailsService;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final MyUserDetailsService manager;
    private final PasswordEncoder encoder;
    private UserRepository userRepository;
    private ImageRepository imageRepository;
    @Override
    public void setPassword(NewPasswordDto newPasswordDto, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        user.setPassword(encoder.encode(newPasswordDto.getNewPassword()));
        userRepository.save(user);///Добавить проверку на совпадение нового и старого паролей
    }

    @Override
    public UserDto getInfo(String name) {
        User user = userRepository.findByEmail(name);
        return userMapper.mapToUserDto(user);
    }

    @Override
    public UpdateUserDto updateUser(UpdateUserDto updateUser, Authentication authentication) {
        User user = userMapper.mapFromUpdateUserDtoToUser(updateUser, authentication);
        userRepository.save(user);
        return userMapper.mapFromUserToUpdateUserDto(user);
    }//достать юзера из сессии и обновить

    @Override
    public UserDto findById(Integer userId) {
        List<User> user = userRepository.findAllById(Collections.singleton(userId));
        return userMapper.mapToUserDto(user.get(0));/// Как проще это сделать? это топорный способ. А это вообще нужно?(используется в admapper в методе mapToAd)
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
