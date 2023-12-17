package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "/users")
//@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/set_password")
    public void setPassword(@RequestBody(required = false) NewPasswordDto newPasswordDto) {
        userService.setPassword(newPasswordDto);
        }
    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getInfo(Authentication authentication) {
        return ResponseEntity.ok(userService.getInfo(authentication.getName()));
        }
    @PatchMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateUserDto> updateInfo(@RequestBody(required = false) UpdateUserDto updateUser) {
        return ResponseEntity.ok(userService.updateUser());
        }
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateImage(@RequestPart MultipartFile image) {
        }
}
