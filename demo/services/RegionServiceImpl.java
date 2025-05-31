package co.edu.udes.activity.backend.demo.services;

import co.edu.udes.activity.backend.demo.dto.RegionDTO;
import co.edu.udes.activity.backend.demo.models.Continent;
import co.edu.udes.activity.backend.demo.models.Country;
import co.edu.udes.activity.backend.demo.models.Region;
import co.edu.udes.activity.backend.demo.repositories.ContinentRepository;
import co.edu.udes.activity.backend.demo.repositories.CountryRepository;
import co.edu.udes.activity.backend.demo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    private RegionDTO convertToDTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setRegionId(region.getRegionId());
        dto.setName(region.getName());
        if (region.getContinent() != null) {
            dto.setContinentId(region.getContinent().getContinentId());
        }
        if (region.getCountries() != null) {
            dto.setCountryIds(region.getCountries()
                .stream()
                .map(Country::getCountryId)
                .collect(Collectors.toList()));
        }
        return dto;
    }

    private Region convertToEntity(RegionDTO dto) {
        Region region = new Region();
        region.setRegionId(dto.getRegionId());
        region.setName(dto.getName());

        if (dto.getContinentId() != null) {
            Continent continent = continentRepository.findById(dto.getContinentId()).orElse(null);
            region.setContinent(continent);
        }

        if (dto.getCountryIds() != null) {
            List<Country> countries = countryRepository.findAllById(dto.getCountryIds());
            region.setCountries(countries);
        }

        return region;
    }

    @Override
    public List<RegionDTO> getAllRegions() {
        return regionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RegionDTO getRegionById(Long id) {
        return regionRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public RegionDTO createRegion(RegionDTO dto) {
        Region region = convertToEntity(dto);
        return convertToDTO(regionRepository.save(region));
    }

    @Override
    public RegionDTO updateRegion(Long id, RegionDTO dto) {
        if (!regionRepository.existsById(id)) return null;
        Region region = convertToEntity(dto);
        region.setRegionId(id);
        return convertToDTO(regionRepository.save(region));
    }

    @Override
    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }
}