package co.edu.udes.activity.backend.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private Long countryId;

    private String name;
    private Double area;

    @Column(name = "national_day")
    private LocalDate nationalDay;

    @Column(name = "country_code2")
    private String countryCode2;

    @Column(name = "country_code3")
    private String countryCode3;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "country")
    private List<CountryStats> stats;

    @OneToMany(mappedBy = "country")
    private List<CountryLanguage> countryLanguages;
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

    public Region getRegion() {
        return region;
    }

    // Setters
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

    public void setRegion(Region region) {
        this.region = region;
    }

}