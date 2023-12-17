package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;

import java.io.IOException;
import java.util.Optional;

public interface AdsService {
    AdsDto getAllAds();

    AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication);

    ExtendedAdDto getInfoExtendedAd(Integer id);

    void deleteAd(Integer id);

    AdDto patchAd(Integer id, CreateOrUpdateAdDto dto);

    AdsDto getUserAds();

    String patchImage(Integer id, MultipartFile multipartFile) throws IOException;

    Optional<Ad> findById(Integer id);
}
