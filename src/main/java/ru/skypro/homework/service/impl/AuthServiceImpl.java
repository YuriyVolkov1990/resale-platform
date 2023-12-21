package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.manager.MyUserDetailsService;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MyUserDetailsService manager;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    public AuthServiceImpl(MyUserDetailsService manager,
                           PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.manager = manager;
        this.encoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        User userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterDto register) {
        if (manager.userExists(register.getUsername())) {
            return false;
        }
        register.setPassword(encoder.encode(register.getPassword()));
        manager.createUser(userMapper.mapFromRegisterDtoToUser(register));
        return true;
    }

}
//User.builder()
//        .passwordEncoder(this.encoder::encode)
//        .password(register.getPassword())
//        .username(register.getUsername())
//        .roles(register.getRole().name())
//        .build()