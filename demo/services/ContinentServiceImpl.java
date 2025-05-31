package co.edu.udes.activity.backend.demo.services;

import co.edu.udes.activity.backend.demo.dto.ContinentDTO;
import co.edu.udes.activity.backend.demo.models.Continent;
import co.edu.udes.activity.backend.demo.models.Region;
import co.edu.udes.activity.backend.demo.repositories.ContinentRepository;
import co.edu.udes.activity.backend.demo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private RegionRepository regionRepository;

    private ContinentDTO convertToDTO(Continent continent) {
        ContinentDTO dto = new ContinentDTO();
        dto.setContinentId(continent.getContinentId());
        dto.setName(continent.getName());

        if (continent.getRegions() != null) {
            List<Long> regionIds = continent.getRegions()
                    .stream()
                    .map(Region::getRegionId)
                    .collect(Collectors.toList());
            dto.setRegionIds(regionIds);
        }

        return dto;
    }

    private Continent convertToEntity(ContinentDTO dto) {
        Continent continent = new Continent();
        continent.setContinentId(dto.getContinentId());
        continent.setName(dto.getName());

        if (dto.getRegionIds() != null) {
            List<Region> regions = regionRepository.findAllById(dto.getRegionIds());
            continent.setRegions(regions);
        }

        return continent;
    }

    @Override
    public List<ContinentDTO> getAllContinents() {
        return continentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContinentDTO getContinentById(Long id) {
        return continentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public ContinentDTO createContinent(ContinentDTO dto) {
        Continent continent = convertToEntity(dto);
        return convertToDTO(continentRepository.save(continent));
    }

    @Override
    public ContinentDTO updateContinent(Long id, ContinentDTO dto) {
        if (!continentRepository.existsById(id)) return null;
        Continent updated = convertToEntity(dto);
        updated.setContinentId(id);
        return convertToDTO(continentRepository.save(updated));
    }

    @Override
    public void deleteContinent(Long id) {
        continentRepository.deleteById(id);
    }
}