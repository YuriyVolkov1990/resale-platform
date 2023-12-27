package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final ImageService imageService;

    @Operation(
            tags = "Пользователи",
            summary = "Обновление пароля",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пароль обновлен",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Доступ запрещен",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Пользователь не найден",
                            content = @Content()
                    )
            }
    )
    @PostMapping("/set_password")
    public void setPassword(@RequestBody(required = false) NewPasswordDto newPasswordDto, Authentication authentication) {
        logger.info("Запущен метод UserController setPassword: Обновление пароля");
        userService.setPassword(newPasswordDto, authentication);
    }

    @Operation(
            tags = "Пользователи",
            summary = "Получение информации об авторизованном пользователе",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пользователь найден",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content()
                    )
            }
    )
    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getInfo(Authentication authentication) {
        logger.info("Запущен метод UserController getInfo: Получение информации об авторизованном пользователе");
        return ResponseEntity.ok(userService.getInfo(authentication.getName()));
    }

    @Operation(
            tags = "Пользователи",
            summary = "Изменение данных пользователя",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Пользователь обновлен",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UpdateUserDto.class))),
                    @ApiResponse(responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content())
            }
    )
    @PatchMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateUserDto> updateInfo(@RequestBody(required = false) UpdateUserDto updateUser, Authentication authentication) {
        logger.info("Запущен метод UserController updateInfo: Изменение данных пользователя");
        return ResponseEntity.ok(userService.updateUser(updateUser, authentication));
    }

    @Operation(
            tags = "Пользователи",
            summary = "Обновление аватара авторизованного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Картинка загружена",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован (unauthorized)",
                            content = @Content()
                    )
            }
    )
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateImage(@RequestPart MultipartFile image,
                            Authentication authentication) throws IOException {
        logger.info("Запущен метод UserController updateImage: Обновление аватара авторизованного пользователя");
        imageService.uploadImageToUser(image, authentication);
    }

    @GetMapping(value = "/image/{id}")
    public byte[] getImage(@PathVariable(required = true) Integer id) {
        return imageService.getImage(id);
    }
}
