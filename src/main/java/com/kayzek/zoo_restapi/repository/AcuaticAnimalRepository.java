package com.kayzek.zoo_restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kayzek.zoo_restapi.models.AcuaticAnimal;

public interface AcuaticAnimalRepository extends JpaRepository<AcuaticAnimal, Long>{
    List<AcuaticAnimal> findByWaterType(String waterType);
}
