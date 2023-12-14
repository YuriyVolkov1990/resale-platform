package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.ExtendedAdDto;

public interface AdsService {
    public AdsDto getAllAds();

    AdDto addAd();

    ExtendedAdDto getInfoExtendedAd();

    AdDto deleteAd();

    AdDto patchAd();

    AdsDto getUserAds();

    String patchImage();
}
