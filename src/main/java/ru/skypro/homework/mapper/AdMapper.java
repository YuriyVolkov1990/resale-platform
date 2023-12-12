package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.AdsRepository;

import java.util.ArrayList;
import java.util.List;

public class AdMapper {
    private final UserMapper userMapper;
//    private final AdsRepository adsRepository;

    public AdMapper(UserMapper userMapper, AdsRepository adsRepository) {
        this.userMapper = userMapper;
//        this.adsRepository = adsRepository;
    }

    public AdDto mapToAdDto(Ad ad) {
        AdDto dto = new AdDto();
        dto.setId(ad.getId());
        dto.setImage(ad.getImage());
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        dto.setAuthor(dto.getAuthor());
        return dto;
    }
    public Ad mapToAd(AdDto dto) {
        Ad ad = new Ad();
        ad.setId(dto.getId());
        ad.setImage(dto.getImage());
        ad.setPrice(dto.getPrice());
        ad.setTitle(dto.getTitle());
        return ad;
    }

    public ExtendedAdDto mapToExtendedAdDto(Ad ad, User user) {
        ExtendedAdDto dto = new ExtendedAdDto();
        dto.setImage(ad.getImage());
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        dto.setDescription(ad.getDescription());
        UserDto userDto = userMapper.mapToUserDto(user);
        dto.setAuthorFirstName(userDto.getFirstName());
        dto.setAuthorLastName(userDto.getLastName());
        return dto;
    }

    public Ad mapToAd(ExtendedAdDto dto) {
        Ad ad = new Ad();
        ad.setId(dto.getId());
        ad.setImage(dto.getImage());
        ad.setPrice(dto.getPrice());
        ad.setTitle(dto.getTitle());
        ad.setDescription(dto.getDescription());
        User user = new User(dto.getId(), dto.getEmail(), dto.getAuthorFirstName(), dto.getAuthorLastName(), dto.getPhone(), null, null, null);
        userMapper.mapToUserDto(user);
        return ad;
    }
    public AdsDto mapToAdsDto(List<Ad> ads) {
        AdsDto adsDto = new AdsDto();
        adsDto.setResults(ads);
        Integer count = ads.size();
        adsDto.setCount(count);
        return adsDto;
    }
    public List<Ad> mapToAds(AdsDto adsDto) {
        List<Ad> ads = new ArrayList<>();
        for (int i = 0; i <= adsDto.getCount(); i++) {
            ads.add(i,adsDto.getResults().get(i));
        }
        return ads;
    }

    public CreateOrUpdateAdDto mapToCreateOrUpdateAdDto(Ad ad) {
        CreateOrUpdateAdDto dto = new CreateOrUpdateAdDto();
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        dto.setDescription(ad.getDescription());
        return dto;
    }
}
