package ru.skypro.homework.service.impl;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdsService;

public class AdsServiceImpl implements AdsService {

    @Override
    public AdsDto getAllAds() {
        return null;// достать все обьявы из репозитория
    }

    @Override
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image) {
        return null;
    }//createorupdatedto and MultipartFile

    @Override
    public ExtendedAdDto getInfoExtendedAd(Integer id) {
        return null;
    }//достать обявление по d и положить в dto

    @Override
    public AdDto deleteAd(Integer id) {
        return null;
        // он void, можно ничего не возвращать
    }

    @Override
    public AdDto patchAd(Integer id) {
        return null;
    }//аналогично update student, faculty достать по id, обновить данными, которые пришли из дто

    @Override
    public AdsDto getUserAds() {
        return null;
    }//id пользователя берем из userDetails, запрашиваем у репорзитория все обявления с ид нужного пользователя

    @Override
    public String patchImage(Integer id, MultipartFile multipartFile) {
        return null;
    }//id это ид объявления, не картинки!!!
}
