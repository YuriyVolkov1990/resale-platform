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
import ru.skypro.homework.UserDetailsService.MyUserDetailsService;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
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
    private final ImageService imageService;
    @Override
    public void setPassword(NewPasswordDto newPasswordDto, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        user.setPassword(encoder.encode(newPasswordDto.getNewPassword()));
        userRepository.save(user);
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
    }

    @Override
    public UserDto findById(Integer userId) {
        List<User> user = userRepository.findAllById(Collections.singleton(userId));
        return userMapper.mapToUserDto(user.get(0));
    }

    @Override
    public void patchImage (MultipartFile image, Authentication authentication) throws IOException {
        imageService.uploadImageToUser(image, authentication);
    }
}
