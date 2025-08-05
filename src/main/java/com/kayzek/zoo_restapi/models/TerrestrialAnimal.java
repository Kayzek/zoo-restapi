package com.kayzek.zoo_restapi.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TerrestrialAnimal extends Animal {
    private Double maxSpeed;
    private String tipoTerritorio;
    private boolean territorial;

    public TerrestrialAnimal() {
    }

    public TerrestrialAnimal(String name, String species, Integer age, double weight, LocalDate registerDate, HealthStatus healthStatus, 
    Diet diet, Double maxSpeed, String tipoTerritorio, boolean territorial) {
        super(name, species, age, weight, registerDate, healthStatus, diet);
        this.maxSpeed = maxSpeed;
        this.tipoTerritorio = tipoTerritorio;
        this.territorial = territorial;
    }
}
