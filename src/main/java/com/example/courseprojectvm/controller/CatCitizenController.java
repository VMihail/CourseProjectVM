package com.example.courseprojectvm.controller;

import com.example.courseprojectvm.entity.CatCitizen;
import com.example.courseprojectvm.service.CatCitizenService;
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

import java.util.List;

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
    public CatCitizen getCatCitizenById(@PathVariable Long id) {
        return catCitizenService.findById(id);
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
