package ru.skypro.homework.controller;

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
        return ResponseEntity.ok(adsService.addAd());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDto> getInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(adsService.getInfoExtendedAd());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdDto> deleteAd(@PathVariable Integer id) {
        return ResponseEntity.ok(adsService.deleteAd());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AdDto> patchAd(@PathVariable Integer id) {
        return ResponseEntity.ok(adsService.patchAd());
    }

    @GetMapping("/me")
    public ResponseEntity<AdsDto> getUserAds() {
        return ResponseEntity.ok(adsService.getUserAds());
    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<>
}
