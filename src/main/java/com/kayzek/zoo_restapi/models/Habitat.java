package com.kayzek.zoo_restapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String habitatName;
    private String habitatDescription;
    private String habitatType;
    private String area;
    private String climate;
    private Integer maxCapacity;

    @OneToMany(mappedBy = "habitat")
    private java.util.List<Animal> animals;

}
