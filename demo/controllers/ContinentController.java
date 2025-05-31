package co.edu.udes.activity.backend.demo.controllers;

import co.edu.udes.activity.backend.demo.dto.ContinentDTO;
import co.edu.udes.activity.backend.demo.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
@CrossOrigin("*")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping
    public List<ContinentDTO> getAllContinents() {
        return continentService.getAllContinents();
    }

    @GetMapping("/{id}")
    public ContinentDTO getContinentById(@PathVariable Long id) {
        return continentService.getContinentById(id);
    }

    @PostMapping
    public ContinentDTO createContinent(@RequestBody ContinentDTO dto) {
        return continentService.createContinent(dto);
    }

    @PutMapping("/{id}")
    public ContinentDTO updateContinent(@PathVariable Long id, @RequestBody ContinentDTO dto) {
        return continentService.updateContinent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteContinent(@PathVariable Long id) {
        continentService.deleteContinent(id);
    }
}
