package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdsService;

import javax.validation.Valid;

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

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<AdDto> addAd(@Valid @RequestBody(required = false) CreateOrUpdateAdDto properties, @RequestBody(required = false) MultipartFile image) {
//            return new ResponseEntity<AdDto>(adsService.addAd(properties, image),HttpStatus.CREATED);
//    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AdDto addAd(@Valid @RequestBody(required = false) CreateOrUpdateAdDto properties, @RequestBody(required = false) MultipartFile image) {
        return adsService.addAd(properties, image);
    }

    @GetMapping("/{id}")
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

    @PatchMapping("/{id}")
    public ResponseEntity<AdDto> patchAd(@PathVariable(required = true) Integer id, @RequestBody(required = false) CreateOrUpdateAdDto dto) {
            return ResponseEntity.ok(adsService.patchAd(id));
    }

    @GetMapping("/me")
    public ResponseEntity<AdsDto> getUserAds() {
            return ResponseEntity.ok(adsService.getUserAds());
    }

    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> patchImage(@PathVariable(required = true) Integer id, @RequestBody(required = false) MultipartFile image) {
            return ResponseEntity.ok(adsService.patchImage(id, image));
    }
}
