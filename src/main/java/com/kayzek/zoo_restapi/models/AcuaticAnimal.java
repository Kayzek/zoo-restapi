package com.kayzek.zoo_restapi.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AcuaticAnimal extends Animal {
    private Double maxDepth;
    private String waterType;
    private boolean Migratory;

    public AcuaticAnimal() {
    }

    public AcuaticAnimal(String name, String species, Integer age, double weight, LocalDate registerDate, 
    HealthStatus healthStatus, Diet diet, Double maxDepth, String waterType, boolean migratory) {
        super(name, species, age, weight, registerDate, healthStatus, diet);
        this.maxDepth = maxDepth;
        this.waterType = waterType;
        this.Migratory = migratory;
    }
}
