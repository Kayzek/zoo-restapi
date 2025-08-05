package com.kayzek.zoo_restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kayzek.zoo_restapi.models.Diet;
import com.kayzek.zoo_restapi.models.TerrestrialAnimal;

public interface TerrestrialAnimalRepository extends JpaRepository<TerrestrialAnimal, Long> {
    List<TerrestrialAnimal> findByTerritorialTrue();
    List<TerrestrialAnimal> findByDiet(Diet diet);
}
