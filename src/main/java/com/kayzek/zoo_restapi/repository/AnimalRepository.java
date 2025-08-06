package com.kayzek.zoo_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kayzek.zoo_restapi.models.Animal;
import java.util.List;


// Interfaz base de animal
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // metodos generales
    List<Animal> findByHabitatId(Long id);
}
