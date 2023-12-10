package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.entity.Ad;

import java.util.List;

@Data
public class AdsDto {
    private Integer count;
    private List<Ad> results;

    public AdsDto() {
    }

    public AdsDto(Integer count, List<Ad> results) {
        this.count = count;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Ad> getResults() {
        return results;
    }

    public void setResults(List<Ad> results) {
        this.results = results;
    }
}
