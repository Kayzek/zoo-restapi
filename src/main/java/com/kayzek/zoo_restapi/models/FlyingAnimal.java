package com.kayzek.zoo_restapi.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FlyingAnimal extends Animal {
    private Double maxHeight;
    private boolean migratory;
    
    @Enumerated(EnumType.STRING)
    private FlyingType flyingType;

    public FlyingAnimal() { }

    public FlyingAnimal(String name, String species, Integer age, double weight, LocalDate registerDate, 
    HealthStatus healthStatus, Diet diet, double maxHeight, boolean migratory, FlyingType flyingType) {
        super(name, species, age, weight, registerDate, healthStatus, diet);
        this.maxHeight = maxHeight;
        this.migratory = migratory;
        this.flyingType = flyingType;
    }
}
