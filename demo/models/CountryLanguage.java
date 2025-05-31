package co.edu.udes.activity.backend.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "country_languages")
@Data
public class CountryLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String languageName;
    private Boolean official;
    

   
    @ManyToOne 
    @JoinColumn(name = "country_id") 
    private Country country; 
}