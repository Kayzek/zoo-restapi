package com.kayzek.zoo_restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayzek.zoo_restapi.models.Animal;
import com.kayzek.zoo_restapi.repository.AnimalRepository;

@Service
public class AnimalService {
    

    // inyeccion de dependencias
    // contiene separacion de responsabilidades

    @Autowired
    private AnimalRepository animalRepository;
    // metodos CRUD - logica de negocio
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
