package com.kayzek.zoo_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kayzek.zoo_restapi.models.Animal;
import java.util.List;


// Interfaz base de animal
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // metodos generales
    List<Animal> findBySpecies(String species);
    List<Animal> findByHabitatId(Long id);

    // querys
    @Query("SELECT a FROM Animal a WHERE TYPE(a) = FlyingAnimal")
    List<Animal> findByFlyingAnimals();
    @Query("SELECT a FROM Animal a WHERE TYPE(a) = TerrestrialAnimal")
    List<Animal> findByTerrestriAnimals();
    @Query("SELECT a FROM Animal a WHERE TYPE(a) = ActuaticAnimal")
    List<Animal> findByActuaticAnimals();
}
