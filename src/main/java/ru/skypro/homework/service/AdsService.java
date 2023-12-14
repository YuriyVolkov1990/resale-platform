package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.ExtendedAdDto;

public interface AdsService {
    AdsDto getAllAds();

    AdDto addAd(Object properties, MultipartFile image);

    ExtendedAdDto getInfoExtendedAd(Integer id);

    AdDto deleteAd(Integer id);

    AdDto patchAd(Integer id);

    AdsDto getUserAds();

    String patchImage(Integer id);
}
