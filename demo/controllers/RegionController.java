package co.edu.udes.activity.backend.demo.controllers;

import co.edu.udes.activity.backend.demo.dto.RegionDTO;
import co.edu.udes.activity.backend.demo.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@CrossOrigin("*")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<RegionDTO> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{id}")
    public RegionDTO getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @PostMapping
    public RegionDTO createRegion(@RequestBody RegionDTO dto) {
        return regionService.createRegion(dto);
    }

    @PutMapping("/{id}")
    public RegionDTO updateRegion(@PathVariable Long id, @RequestBody RegionDTO dto) {
        return regionService.updateRegion(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
}