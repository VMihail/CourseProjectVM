package com.example.courseprojectvm.service;

import com.example.courseprojectvm.entity.CatCitizen;
import com.example.courseprojectvm.repository.CatCitizenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatCitizenService {

    private final CatCitizenRepository catCitizenRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @Transactional
    public List<CatCitizen> findAll() {
        return catCitizenRepository.findAll();
    }

    @Transactional
    public CatCitizen findById(Long id) {
        return catCitizenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Transactional
    public CatCitizen save(CatCitizen catCitizen) {
        messagingTemplate.convertAndSend("/topic/citizens", "New cat citizen: " + catCitizen.getName());
        return catCitizenRepository.save(catCitizen);
    }

    @Transactional
    public void deleteById(Long id) {
        catCitizenRepository.deleteById(id);
    }

    @Transactional
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
