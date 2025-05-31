package co.edu.udes.activity.backend.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.udes.activity.backend.demo.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
