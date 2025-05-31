package co.edu.udes.activity.backend.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "continents")
public class Continent {

    @Id
    @Column(name = "continent_id")
    private Long continentId;

    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Region> regions;
    
    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}