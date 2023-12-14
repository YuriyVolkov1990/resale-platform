package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdsService;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping
    public ResponseEntity<AdsDto> getAllAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

    @PostMapping
    public ResponseEntity<AdDto> addAd(@RequestParam Object properties, @RequestParam MultipartFile image) {
        if () {
            return ResponseEntity.ok(adsService.addAd(properties, image));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDto> getInfo(@PathVariable Integer id) {
        if () {
            return ResponseEntity.ok(adsService.getInfoExtendedAd(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
//404 Not found????????
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdDto> deleteAd(@PathVariable Integer id) {
        if () {
            return ResponseEntity.ok(adsService.deleteAd(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
//Forbidden????
//Not found????
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdDto> patchAd(@PathVariable Integer id) {
        if () {
            return ResponseEntity.ok(adsService.patchAd(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
//Forbidden????
//Not found????
    }

    @GetMapping("/me")
    public ResponseEntity<AdsDto> getUserAds() {
        if () {
            return ResponseEntity.ok(adsService.getUserAds());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<String> patchImage(@PathVariable Integer id) {
        if () {
            return ResponseEntity.ok(adsService.patchImage(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
