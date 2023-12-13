package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;

public interface AdsService {
    public AdsDto getAllAds();

    AdDto addAd();
}
