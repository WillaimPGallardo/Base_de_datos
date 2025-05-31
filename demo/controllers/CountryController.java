package co.edu.udes.activity.backend.demo.controllers;

import co.edu.udes.activity.backend.demo.dto.CountryDTO;
import co.edu.udes.activity.backend.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryDTO getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryDTO createCountry(@RequestBody CountryDTO dto) {
        return countryService.createCountry(dto);
    }

    @PutMapping("/{id}")
    public CountryDTO updateCountry(@PathVariable Long id, @RequestBody CountryDTO dto) {
        return countryService.updateCountry(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}