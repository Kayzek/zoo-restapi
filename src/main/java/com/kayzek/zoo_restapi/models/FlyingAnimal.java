package com.kayzek.zoo_restapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FlyingAnimal extends Animal {
    private boolean Migratory;
    
    @Enumerated(EnumType.STRING)
    private FlyingType flyingType;

    public FlyingAnimal() { }

    public FlyingAnimal(String name, String species, Integer age, double weight, LocalDate registerDate, HealthStatus healthStatus, boolean migratory, FlyingType flyingType) {
        super(name, species, age, weight, registerDate, healthStatus);
        this.Migratory = migratory;
        this.flyingType = flyingType;
    }
}
