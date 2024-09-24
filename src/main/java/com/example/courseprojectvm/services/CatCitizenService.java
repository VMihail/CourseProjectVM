package com.example.courseprojectvm.services;

import com.example.courseprojectvm.entities.CatCitizen;
import com.example.courseprojectvm.repositories.CatCitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatCitizenService {

    private final CatCitizenRepository catCitizenRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public CatCitizenService(CatCitizenRepository catCitizenRepository, SimpMessagingTemplate messagingTemplate) {
        this.catCitizenRepository = catCitizenRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public List<CatCitizen> findAll() {
        return catCitizenRepository.findAll();
    }

    public Optional<CatCitizen> findById(Long id) {
        return catCitizenRepository.findById(id);
    }

    public CatCitizen save(CatCitizen catCitizen) {
        messagingTemplate.convertAndSend("/topic/citizens", "New cat citizen: " + catCitizen.getName());
        return catCitizenRepository.save(catCitizen);
    }

    public void deleteById(Long id) {
        catCitizenRepository.deleteById(id);
    }

    public CatCitizen update(Long id, CatCitizen updatedCatCitizen) {
        Optional<CatCitizen> existingCatCitizen = catCitizenRepository.findById(id);
        if (existingCatCitizen.isPresent()) {
            CatCitizen catCitizen = existingCatCitizen.get();
            catCitizen.setName(updatedCatCitizen.getName());
            catCitizen.setImageUrl(updatedCatCitizen.getImageUrl());
            return catCitizenRepository.save(catCitizen);
        } else {
            return null;
        }
    }
}
