package co.edu.udes.activity.backend.demo.dto;

import java.util.List;

public class ContinentDTO {

    private Long continentId;
    private String name;
    private List<Long> regionIds;

  
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

    public List<Long> getRegionIds() {
        return regionIds;
    }

    public void setRegionIds(List<Long> regionIds) {
        this.regionIds = regionIds;
    }
}
