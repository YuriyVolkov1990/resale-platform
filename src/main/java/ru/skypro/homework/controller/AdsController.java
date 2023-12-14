package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
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
    public ResponseEntity<AdDto> addAd(@RequestParam CreateOrUpdateAdDto properties, @RequestParam MultipartFile image) {
            return ResponseEntity.ok(adsService.addAd(properties, image));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDto> getInfo(@PathVariable Integer id) {
            return ResponseEntity.ok(adsService.getInfoExtendedAd(id));
        //404 Not found????????
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdDto> deleteAd(@PathVariable Integer id) {
            return ResponseEntity.ok(adsService.deleteAd(id));
//Not found????
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdDto> patchAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAdDto) {
            return ResponseEntity.ok(adsService.patchAd(id));
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
