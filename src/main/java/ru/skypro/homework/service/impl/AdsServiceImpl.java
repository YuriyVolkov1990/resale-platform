package ru.skypro.homework.service.impl;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdsService;

public class AdsServiceImpl implements AdsService {

    @Override
    public AdsDto getAllAds() {
        return null;
    }

    @Override
    public AdDto addAd(Object properties, MultipartFile image) {
        return null;
    }

    @Override
    public ExtendedAdDto getInfoExtendedAd(Integer id) {
        return null;
    }

    @Override
    public AdDto deleteAd(Integer id) {
        return null;
    }

    @Override
    public AdDto patchAd(Integer id) {
        return null;
    }

    @Override
    public AdsDto getUserAds() {
        return null;
    }

    @Override
    public String patchImage(Integer id) {
        return null;
    }
}
