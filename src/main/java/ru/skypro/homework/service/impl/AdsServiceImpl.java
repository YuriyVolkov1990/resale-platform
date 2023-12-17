package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.service.AdsService;

import java.util.*;

@Service
public class AdsServiceImpl implements AdsService {
    private AdsRepository adsRepository;
    private AdMapper adMapper;
    private UserDetailsManager userDetailsManager;

    @Override
    public AdsDto getAllAds() {
        List<Ad> adsList = adsRepository.findAll();
        List<AdDto> adDtoList = new ArrayList<>();
        for (int i = 0; i <= adsList.size(); i++) {
            AdDto adDto = adMapper.mapToAdDto(adsList.get(i));
            adDtoList.add(adDto);
        }
        return new AdsDto(adDtoList.size(),adDtoList);// достать все обьявы из репозитория
    }

    @Override
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication) {
        Ad ad = new Ad();
        ad.setTitle(properties.getTitle());
        ad.setPrice(properties.getPrice());
        ad.setDescription(properties.getDescription());
        ad.setImage(image.getName());
        ad.setUser((User) authentication.getPrincipal());
        return adMapper.mapToAdDto(ad);
    }//createorupdatedto and MultipartFile

    @Override
    public ExtendedAdDto getInfoExtendedAd(Integer id) {
        Optional<Ad> adOp = adsRepository.findById(id);
        Ad ad = null;
        if (adOp.isPresent()) {
            ad = adOp.get();
        }
        return adMapper.mapToExtendedAdDto(Objects.requireNonNull(ad), ad.getUser());
        //достать обявление по id и положить в dto
    }
    @Override
    public void deleteAd (Integer id){
        Optional<Ad> adOp = adsRepository.findById(id);
        Ad ad = null;
        if (adOp.isPresent()) {
            ad = adOp.get();
            adsRepository.delete(ad);
        }
        // он void, можно ничего не возвращать
    }

    @Override
    public AdDto patchAd (Integer id, CreateOrUpdateAdDto dto){
        Ad existingAd = adsRepository.findById(id).orElseThrow(AdNotFoundException::new);
        existingAd.setTitle(dto.getTitle());
        existingAd.setPrice(dto.getPrice());
        existingAd.setDescription(dto.getDescription());
        adsRepository.save(existingAd);
        return adMapper.mapToAdDto(existingAd);
    }//аналогично update student, faculty достать по id, обновить данными, которые пришли из дто

    @Override
    public AdsDto getUserAds () {

        return null;
    }//id пользователя берем из userDetails, запрашиваем у репорзитория все обявления с ид нужного пользователя

    @Override
    public String patchImage (Integer id, MultipartFile multipartFile){
        return null;
    }//id это ид объявления, не картинки!!!

    @Override
    public Optional<Ad> findById (Integer id){
        return adsRepository.findById(id);

    }
    }