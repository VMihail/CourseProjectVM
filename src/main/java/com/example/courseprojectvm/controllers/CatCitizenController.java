package com.example.courseprojectvm.controllers;

import com.example.courseprojectvm.entities.CatCitizen;
import com.example.courseprojectvm.services.CatCitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cat-citizens")
public class CatCitizenController {

    private final CatCitizenService catCitizenService;

    @Autowired
    public CatCitizenController(CatCitizenService catCitizenService) {
        this.catCitizenService = catCitizenService;
    }

    @GetMapping
    public List<CatCitizen> getAllCatCitizens() {
        return catCitizenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatCitizen> getCatCitizenById(@PathVariable Long id) {
        Optional<CatCitizen> catCitizen = catCitizenService.findById(id);
        return catCitizen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CatCitizen createCatCitizen(@RequestBody CatCitizen catCitizen) {
        return catCitizenService.save(catCitizen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatCitizen> updateCatCitizen(@PathVariable Long id, @RequestBody CatCitizen catCitizen) {
        CatCitizen updatedCatCitizen = catCitizenService.update(id, catCitizen);
        if (updatedCatCitizen != null) {
            return ResponseEntity.ok(updatedCatCitizen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatCitizen(@PathVariable Long id) {
        catCitizenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
