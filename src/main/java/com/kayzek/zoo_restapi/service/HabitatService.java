package com.kayzek.zoo_restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayzek.zoo_restapi.models.Habitat;
import com.kayzek.zoo_restapi.repository.HabitatRepository;

@Service
public class HabitatService {
    
    @Autowired
    private HabitatRepository habitatRepository;
    public List<Habitat> getAllHabitats() {
        return habitatRepository.findAll();
    }
    
    public Habitat getHabitatById(Long id) {
        return habitatRepository.findById(id).orElse(null);
    }


    public Habitat saveHabitat(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    public void deleteHabitat(Long id) {
        habitatRepository.deleteById(id);
    }
}
