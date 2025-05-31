package co.edu.udes.activity.backend.demo.services;

import co.edu.udes.activity.backend.demo.dto.CountryDTO;
import co.edu.udes.activity.backend.demo.models.Country;
import co.edu.udes.activity.backend.demo.models.Region;
import co.edu.udes.activity.backend.demo.repositories.CountryRepository;
import co.edu.udes.activity.backend.demo.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    private CountryDTO convertToDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setCountryId(country.getCountryId());
        dto.setName(country.getName());
        dto.setArea(country.getArea());
        dto.setNationalDay(country.getNationalDay());
        dto.setCountryCode2(country.getCountryCode2());
        dto.setCountryCode3(country.getCountryCode3());
        dto.setRegionId(country.getRegion().getRegionId());
        return dto;
    }

    private Country convertToEntity(CountryDTO dto) {
        Country country = new Country();
        country.setCountryId(dto.getCountryId());
        country.setName(dto.getName());
        country.setArea(dto.getArea());
        country.setNationalDay(dto.getNationalDay());
        country.setCountryCode2(dto.getCountryCode2());
        country.setCountryCode3(dto.getCountryCode3());

        Region region = regionRepository.findById(dto.getRegionId()).orElse(null);
        country.setRegion(region);

        return country;
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CountryDTO getCountryById(Long id) {
        return countryRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public CountryDTO createCountry(CountryDTO dto) {
        Country country = convertToEntity(dto);
        return convertToDTO(countryRepository.save(country));
    }

    @Override
    public CountryDTO updateCountry(Long id, CountryDTO dto) {
        Country existing = countryRepository.findById(id).orElse(null);
        if (existing == null) return null;
        Country updated = convertToEntity(dto);
        updated.setCountryId(id);
        return convertToDTO(countryRepository.save(updated));
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}