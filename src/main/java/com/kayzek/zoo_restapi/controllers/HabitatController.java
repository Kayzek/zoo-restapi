package com.kayzek.zoo_restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kayzek.zoo_restapi.models.Habitat;
import com.kayzek.zoo_restapi.service.HabitatService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/habitat")
public class HabitatController {

    @Autowired
    private HabitatService habitatService;

    @GetMapping
    public List<Habitat> getAllHabitats() {
        return habitatService.getAllHabitats();
    }
    
    @GetMapping("/{id}")
    public Habitat getHabitatById(@PathVariable Long id) {
        return habitatService.getHabitatById(id);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Habitat> createHabitat(@RequestBody Habitat habitat) {
        return ResponseEntity.ok(habitatService.saveHabitat(habitat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitat> updateHabitat(@PathVariable Long id, @RequestBody Habitat habitat) {
        Habitat existingHabitat = habitatService.getHabitatById(id);
        if (existingHabitat == null) {
            return ResponseEntity.notFound().build();
        }
        habitat.setId(id);
        Habitat updatedHabitat = habitatService.saveHabitat(habitat);
        return ResponseEntity.ok(updatedHabitat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitat(@PathVariable Long id) {
        if (habitatService.getHabitatById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        habitatService.deleteHabitat(id);
        return ResponseEntity.noContent().build();
    }

    
}
