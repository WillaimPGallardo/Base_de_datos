package co.edu.udes.activity.backend.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @Column(name = "region_id")
    private Long regionId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "region")
    private List<Country> countries;


    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}