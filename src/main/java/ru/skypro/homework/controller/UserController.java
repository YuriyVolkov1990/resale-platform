package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Objects;

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
        //UNAUTHORIZED??? нужно обработать код, как? Или FORBIDDEN?
        if (!Objects.equals(newPasswordDto.getCurrentPassword(), newPasswordDto.getNewPassword())) {
            return ResponseEntity.ok(userService.setPassword(newPasswordDto));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getInfo() {
        if (????) {
            return ResponseEntity.ok(userService.getInfo());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDto> updateInfo(@RequestBody UpdateUserDto updateUser) {
        if (????) {
            return ResponseEntity.ok(userService.updateUser());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

//    @PatchMapping("/me/image")
//    public ResponseEntity<UserDto> updateImage(String image) {
//
//    }
}
