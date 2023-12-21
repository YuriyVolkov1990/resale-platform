package ru.skypro.homework.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdsDto {

    private List<AdDto> results;
    private Integer count;

    public AdsDto() {
    }

//    public AdsDto(Integer count, List<AdDto> results) {
//        this.count = count;
//        this.results = results;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public List<AdDto> getResults() {
//        return results;
//    }
//
//    public void setResults(List<AdDto> results) {
//        this.results = results;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
}

