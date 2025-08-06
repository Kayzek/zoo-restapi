package com.kayzek.zoo_restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kayzek.zoo_restapi.models.Animal;
import com.kayzek.zoo_restapi.service.AnimalService;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {

    // Inyectar el servicio
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }
    
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
          return ResponseEntity.ok(animalService.saveAnimal(animal));  
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        Animal existingAnimal = animalService.getAnimalById(id);
        if (existingAnimal == null) {
            return ResponseEntity.notFound().build();
        }
        animal.setId(id);
        Animal updatedAnimal = animalService.saveAnimal(animal);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (animalService.getAnimalById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
