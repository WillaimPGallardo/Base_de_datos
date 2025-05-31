package co.edu.udes.activity.backend.demo.services;

import co.edu.udes.activity.backend.demo.dto.RegionDTO;
import java.util.List;

public interface RegionService {
    List<RegionDTO> getAllRegions();
    RegionDTO getRegionById(Long id);
    RegionDTO createRegion(RegionDTO dto);
    RegionDTO updateRegion(Long id, RegionDTO dto);
    void deleteRegion(Long id);
}

