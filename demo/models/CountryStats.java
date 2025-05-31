package co.edu.udes.activity.backend.demo.models;

import jakarta.persistence.*;
import lombok.Data; 

@Entity
@Table(name = "country_stats") 
@Data
public class CountryStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Long population;
    private Double gdp;
    private String measurementDate; 

    
    @ManyToOne 
    @JoinColumn(name = "country_id") 
    private Country country; 
    
}