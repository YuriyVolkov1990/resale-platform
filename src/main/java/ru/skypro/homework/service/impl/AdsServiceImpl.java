package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.service.AdsService;

import java.util.Optional;

@Service
public class AdsServiceImpl implements AdsService {
    private AdsRepository adsRepository;

    @Override
    public AdsDto getAllAds() {

        return null;// достать все обьявы из репозитория
    }

    @Override
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication) {
        return null;
    }//createorupdatedto and MultipartFile

    @Override
    public ExtendedAdDto getInfoExtendedAd(Integer id) {
        return null;
    }//достать обявление по id и положить в dto

    @Override
    public AdDto deleteAd(Integer id) {
        return null;
        // он void, можно ничего не возвращать
    }

    @Override
    public AdDto patchAd(Integer id, CreateOrUpdateAdDto dto) {
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

    @Override
    public Optional<Ad> findById(Integer id) {
        return adsRepository.findById(id);

    }
}
