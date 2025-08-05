package com.kayzek.zoo_restapi.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String Species;
    private Integer age;
    private double weight;
    private LocalDate registerDate;

    @Enumerated(EnumType.STRING)
    private HealthStatus healthStatus;
    private Diet diet;

    // relationships
    @ManyToOne
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    public Animal() {
    }

    public Animal(String name, String species, Integer age, double weight, LocalDate registerDate, HealthStatus healthStatus, Diet diet) {
        this.name = name;
        this.Species = species;
        this.age = age;
        this.weight = weight;
        this.registerDate = LocalDate.now();
        this.healthStatus = healthStatus;
        this.diet = diet;
    }

}
