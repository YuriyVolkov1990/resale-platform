package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;

import java.util.*;

@Service
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;
    private final AdMapper adMapper;
    private final ImageRepository imageRepository;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public AdsServiceImpl(AdsRepository adsRepository, AdMapper adMapper, ImageRepository imageRepository, UserMapper userMapper, UserRepository userRepository) {
        this.adsRepository = adsRepository;
        this.adMapper = adMapper;
        this.imageRepository = imageRepository;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    /**
     * Метод возвращает список всех объявлений в виде DTO {@link Ad}.
     *
     * @return возвращает все объявления из БД
     */
    @Override
    public AdsDto getAllAds() {
        List<Ad> adsList = adsRepository.findAll();
        List<AdDto> adDtoList = new ArrayList<>();
        for (int i = 0; i <= adsList.size()-1; i++) {
            AdDto adDto = adMapper.mapToAdDto(adsList.get(i));
            adDtoList.add(adDto);
        }
        return new AdsDto(adDtoList.size(),adDtoList);// достать все обьявы из репозитория
    }

    /**
     * Метод добавляет новое объявление в БД
     *
     * @param properties - DTO модель класса {@link CreateOrUpdateAdDto};
     * @param image      - фотография объявления
     * @return возвращает объявление в виде AdDto
     */
    @Override
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication) {
        Ad ad = new Ad();
        ad.setTitle(properties.getTitle());
        ad.setPrice(properties.getPrice());
        ad.setDescription(properties.getDescription());
        ad.setUser(userRepository.findByEmail(authentication.getName()));
        Image adImage = userMapper.mapMultipartFileToImage(image);
        imageRepository.save(adImage);
        ad.setImage(adImage.getPath());
        System.out.println("===================================");
        System.out.println("adImage.getPath() = " + adImage.getPath());
        System.out.println("===================================");
        adsRepository.save(ad);
        return adMapper.mapToAdDto(ad);
    }

    /**
     * Метод получает информацию об объявлении по id
     *
     * @param id - id объявления
     * @return возвращает ExtendedAdDto
     */
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

    /**
     * Метод удаляет объявление по id
     *
     * @param id - id объявления
     */
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

    /**
     * Метод вносит изменения в объявление
     *
     * @param id  - id объявления
     * @param dto - DTO модель класса {@link CreateOrUpdateAdDto};
     * @return возвращает DTO модель объявления
     */
    @Override
    public AdDto patchAd (Integer id, CreateOrUpdateAdDto dto){
        Ad existingAd = adsRepository.findById(id).orElseThrow(AdNotFoundException::new);
        existingAd.setTitle(dto.getTitle());
        existingAd.setPrice(dto.getPrice());
        existingAd.setDescription(dto.getDescription());
        adsRepository.save(existingAd);
        return adMapper.mapToAdDto(existingAd);
    }//аналогично update student, faculty достать по id, обновить данными, которые пришли из дто

    /**
     * Метод получает все объявления данного пользователя
     */
    @Override
    public AdsDto getUserAds () {

        return null;
    }//id пользователя берем из userDetails, запрашиваем у репорзитория все обявления с ид нужного пользователя

    /**
     * Метод меняет аватар пользователя
     *
     * @param id - идентификатор аватара в базе
     * @param multipartFile - файл нового аватара
     * @return возвращает путь к файлу
     */
    @Override
    public String patchImage (Integer id, MultipartFile multipartFile){
        return null;
    }//id это ид объявления, не картинки!!!

    /**
     * Метод ищет объявление по id
     *
     * @param id - идентификатор объявления в базе
     * @return возвращает Optional<Ad>
     */
    @Override
    public Optional<Ad> findById (Integer id){
        return adsRepository.findById(id);

    }
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    }