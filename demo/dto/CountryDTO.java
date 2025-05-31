package co.edu.udes.activity.backend.demo.dto;

import java.time.LocalDate;

public class CountryDTO {
    private Long countryId;
    private String name;
    private Double area;
    private LocalDate nationalDay;
    private String countryCode2;
    private String countryCode3;
    private Long regionId; 

 
    public Long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public Double getArea() {
        return area;
    }

    public LocalDate getNationalDay() {
        return nationalDay;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public Long getRegionId() {
        return regionId;
    }

   
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setNationalDay(LocalDate nationalDay) {
        this.nationalDay = nationalDay;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
}