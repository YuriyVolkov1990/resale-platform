package ru.skypro.homework.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.service.UserService;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdMapper {
    private final UserMapper userMapper;
    private final UserService userService;

    public AdMapper(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    public AdDto mapToAdDto(Ad ad) {
        AdDto dto = new AdDto();
        dto.setPk(ad.getPk());
        dto.setImage(ad.getImage());
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        dto.setAuthor(ad.getUser().getPk());
        return dto;
    }
    public Ad mapToAd(AdDto dto) {
        Ad ad = new Ad();
        ad.setPk(dto.getPk());
        ad.setImage(dto.getImage());
        ad.setPrice(dto.getPrice());
        ad.setTitle(dto.getTitle());
        UserDto userDto = userService.findById(ad.getPk());
        User user = userMapper.mapToUser(userDto);
        ad.setUser(user);
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
        ad.setPk(dto.getPk());
        ad.setImage(dto.getImage());
        ad.setPrice(dto.getPrice());
        ad.setTitle(dto.getTitle());
        ad.setDescription(dto.getDescription());
        User user = new User(dto.getPk(), dto.getEmail(), dto.getAuthorFirstName(), dto.getAuthorLastName(), dto.getPhone(), null, null, null);
        userMapper.mapToUserDto(user);
        ad.setUser(user);
        return ad;
    }
    public AdsDto mapToAdsDto(List<AdDto> ads) {
        AdsDto adsDto = new AdsDto();
        adsDto.setResults(ads);
        Integer count = ads.size();
        adsDto.setCount(count);
        return adsDto;
    }
    public List<AdDto> mapToAds(AdsDto adsDto) {
        List<AdDto> ads = new ArrayList<>();
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
