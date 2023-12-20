package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdsService;


import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {
    private static final Logger logger = LoggerFactory.getLogger(AdsController.class);
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @Operation(
            tags = "Объявления",
            summary = "Получение всех объявлений",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AdsDto.class)
                            )
                    )
            }
    )
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AdsDto> getAllAds() {
        logger.info("Запущен метод AdsController getAllAds: Получение всех объявлений");
        return ResponseEntity.ok(adsService.getAllAds());
    }

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<AdDto> addAd(@RequestPart CreateOrUpdateAdDto properties, @RequestPart MultipartFile image) {
//            return new ResponseEntity<AdDto>(adsService.addAd(properties, image),HttpStatus.CREATED);
//    }

    @Operation(
            tags = "Объявления",
            summary = "Добавление объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AdDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    )
            }
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public AdDto addAd(@RequestPart CreateOrUpdateAdDto properties,
                       @RequestPart MultipartFile image,
                       Authentication authentication) throws IOException {
        logger.info("Запущен метод AdsController addAd: Добавление объявления");
        return adsService.addAd(properties, image, authentication);
    }

    @Operation(
            tags = "Объявления",
            summary = "Получить информацию об объявлении",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No content",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtendedAdDto> getInfo(@PathVariable Integer id) {
        logger.info("Запущен метод AdsController getInfo: Получить информацию об объявлении");
        return ResponseEntity.ok(adsService.getInfoExtendedAd(id));
    }

    @Operation(
            tags = "Объявления",
            summary = "Удаление объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable(required = true) Integer id) {
        logger.info("Запущен метод AdsController deleteAd: Удаление объявления");
        if (adsService.findById(id).isPresent()) {
            adsService.deleteAd(id);
        }
    }

    @Operation(
            tags = "Объявления",
            summary = "Обновление информации об объявлении",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AdDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @PatchMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AdDto> patchAd(@PathVariable(required = true) Integer id,
                                         @RequestBody(required = false) CreateOrUpdateAdDto dto) {
        logger.info("Запущен метод AdsController patchAd: Обновление информации об объявлении");
        return ResponseEntity.ok(adsService.patchAd(id, dto));
    }

    @Operation(
            tags = "Объявления",
            summary = "Получение объявлений авторизованного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AdsDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    )
            }
    )
    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AdsDto> getUserAds(Authentication authentication) {
        logger.info("Запущен метод AdsController getUserAds: Получение объявлений авторизованного пользователя");
        return ResponseEntity.ok(adsService.getUserAds(authentication));
    }

    @Operation(
            tags = "Объявления",
            summary = "Обновление картинки объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE,
                                    schema = @Schema(implementation = String[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden",
                            content = @Content()
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content()
                    )
            }
    )
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> patchImage(@PathVariable(required = true) Integer id,
                                             @RequestPart MultipartFile image,
                                             Authentication authentication) throws IOException {
        logger.info("Запущен метод AdsController patchImage: Обновление картинки объявления");
        return ResponseEntity.ok(adsService.patchImage(id, image));
    }
}
