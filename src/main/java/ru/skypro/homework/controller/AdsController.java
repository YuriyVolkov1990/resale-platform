package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
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
import ru.skypro.homework.service.CommentService;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {
    private final AdsService adsService;
    private final ImageService imageService;
    private final CommentService commentService;


    public AdsController(AdsService adsService, ImageService imageService, CommentService commentService) {
        this.adsService = adsService;
        this.imageService = imageService;
        this.commentService = commentService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AdsDto> getAllAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<AdDto> addAd(@RequestPart CreateOrUpdateAdDto properties, @RequestPart MultipartFile image) {
//            return new ResponseEntity<AdDto>(adsService.addAd(properties, image),HttpStatus.CREATED);
//    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AdDto addAd(@RequestPart CreateOrUpdateAdDto properties,
                       @RequestPart MultipartFile image,
                       Authentication authentication) {
        return adsService.addAd(properties, image, authentication);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtendedAdDto> getInfo(@PathVariable Integer id) {
            return ResponseEntity.ok(adsService.getInfoExtendedAd(id));
        }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable(required = true) Integer id) {
        if (adsService.findById(id).isPresent()) {
            adsService.deleteAd(id);
        }
    }

    @PatchMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AdDto> patchAd(@PathVariable(required = true) Integer id,
                                         @RequestBody(required = false) CreateOrUpdateAdDto dto) {
            return ResponseEntity.ok(adsService.patchAd(id, dto));
    }

    @GetMapping(value = "/me", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AdsDto> getUserAds() {
            return ResponseEntity.ok(adsService.getUserAds());
    }

    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<String> patchImage(@PathVariable(required = true) Integer id,
                                             @RequestPart MultipartFile image,
                                             Authentication authentication) throws IOException {
            return ResponseEntity.ok(adsService.patchImage(id, image));
    }
}
