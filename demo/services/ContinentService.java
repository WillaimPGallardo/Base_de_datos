package co.edu.udes.activity.backend.demo.services;

import co.edu.udes.activity.backend.demo.dto.ContinentDTO;
import java.util.List;

public interface ContinentService {
    List<ContinentDTO> getAllContinents();
    ContinentDTO getContinentById(Long id);
    ContinentDTO createContinent(ContinentDTO dto);
    ContinentDTO updateContinent(Long id, ContinentDTO dto);
    void deleteContinent(Long id);
}
