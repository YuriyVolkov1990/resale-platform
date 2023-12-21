package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.LoginDto;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.service.AuthService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
//@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            tags = "Авторизация",
            summary = "Авторизация",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Успешная авторизация",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content()
                    )
            }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody(required = false) LoginDto login) {
        logger.info("Запущен метод AuthController login: Авторизация");
        if (authService.login(login.getUsername(), login.getPassword())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Operation(
            tags = "Регистрация",
            summary = "Регистрация",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Успешная регистрация",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректные данные",
                            content = @Content()
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody(required = false) RegisterDto register) {
        logger.info("Запущен метод AuthController register: Регистрация");
        if (authService.register(register)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
