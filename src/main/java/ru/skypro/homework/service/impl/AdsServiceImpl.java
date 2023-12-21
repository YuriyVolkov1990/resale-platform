package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;
    private final AdMapper adMapper;
    private final ImageRepository imageRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ImageService imageService;

//    public AdsServiceImpl(AdsRepository adsRepository, AdMapper adMapper, ImageRepository imageRepository, UserMapper userMapper, UserRepository userRepository, ImageService imageService) {
//        this.adsRepository = adsRepository;
//        this.adMapper = adMapper;
//        this.imageRepository = imageRepository;
//        this.userMapper = userMapper;
//        this.userRepository = userRepository;
//        this.imageService = imageService;
//    }

    @Override
    public AdsDto getAllAds() {
        List<Ad> adsList = adsRepository.findAll();
        List<AdDto> adDtoList = new ArrayList<>();
        for (int i = 0; i <= adsList.size()-1; i++) {
            AdDto adDto = adMapper.mapToAdDto(adsList.get(i));
            adDtoList.add(adDto);
        }
        System.out.println("-----------------");
        System.out.println("new AdsDto(adDtoList.size(),adDtoList) = " + new AdsDto(adDtoList.size(), adDtoList));
        System.out.println("-----------------");
        return new AdsDto(adDtoList.size(),adDtoList);// достать все обьявы из репозитория
    }

    @Override
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication) throws IOException {
        Ad ad = new Ad();
        ad.setTitle(properties.getTitle());
        ad.setPrice(properties.getPrice());
        ad.setDescription(properties.getDescription());
        ad.setUser(userRepository.findByEmail(authentication.getName()));
        ad.setImage(imageService.uploadImageToAd(ad.getPk(),image));
        adsRepository.save(ad);
        return adMapper.mapToAdDto(ad);
    }

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
        return adMapper.mapToAdDto(existingAd);
    }//аналогично update student, faculty достать по id, обновить данными, которые пришли из дто

    @Override
    public AdsDto getUserAds(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName());
        List<Ad> adList = adsRepository.findAdByUser(user);
        List<AdDto> adDtoList = new ArrayList<>();
        for (int i = 0; i <= adList.size(); i++) {
            adDtoList.add(adMapper.mapToAdDto(adList.get(i)));
        }
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("adMapper.mapToAdsDto(adDtoList) = " + adMapper.mapToAdsDto(adDtoList));
        System.out.println("++++++++++++++++++++++++++++");
        return adMapper.mapToAdsDto(adDtoList);
    }//id пользователя берем из userDetails, запрашиваем у репорзитория все обявления с ид нужного пользователя

    @Override
    public String patchImage (Integer adId, MultipartFile multipartFile) throws IOException {
        return imageService.uploadImageToAd(adId, multipartFile);
    }//id это ид объявления, не картинки!!!

    @Override
    public Optional<Ad> findById (Integer id){
        return adsRepository.findById(id);

    }
    }