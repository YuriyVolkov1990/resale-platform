package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.service.UserService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/set_password")
    public ResponseEntity<NewPasswordDto> setPassword(@RequestBody NewPasswordDto newPasswordDto) {
        return ResponseEntity.ok(userService.postPassword(newPasswordDto));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getInfo() {
        return ResponseEntity.ok(userService.getInfo());
    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDto> updateInfo(@RequestBody UpdateUserDto updateUser) {
        return ResponseEntity.ok(userService.updateUser());
    }

//    @PatchMapping("/me/image")
//    public ResponseEntity<UserDto> updateImage() {
//
//    }
}
