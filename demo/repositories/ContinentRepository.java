package co.edu.udes.activity.backend.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.udes.activity.backend.demo.models.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
