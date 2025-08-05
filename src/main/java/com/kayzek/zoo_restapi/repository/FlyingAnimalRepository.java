package com.kayzek.zoo_restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kayzek.zoo_restapi.models.FlyingAnimal;
import com.kayzek.zoo_restapi.models.FlyingType;

public interface FlyingAnimalRepository extends JpaRepository<FlyingAnimal, Long> {
    List<FlyingAnimal> findByMigratoryTrue();
    List<FlyingAnimal> findByFlyingType(FlyingType flyingType);
}