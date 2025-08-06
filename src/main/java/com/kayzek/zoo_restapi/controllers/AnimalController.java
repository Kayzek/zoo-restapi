package com.kayzek.zoo_restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal createAnimal(Animal animal) {
          return animalService.saveAnimal(animal);  
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id);
        return animalService.saveAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    @GetMapping("/volador")
    public List<Animal> getFlyingAnimals(){
        return animalService.getFlyingAnimals();
    }

    @GetMapping("/terrestre")
    public List<Animal> getTerrestrialAnimals(){
        return animalService.getTerrestriAnimals();
    }

    @GetMapping("/acuatico")
    public List<Animal> getAcuaticAnimals(){
        return animalService.getActuaticAnimals();
    }


}
