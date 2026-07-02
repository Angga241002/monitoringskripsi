package com.monitoringskripsi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.repository.SkripsiRepository;

@Service
public class SkripsiService {

    private final SkripsiRepository skripsiRepository;

    public SkripsiService(SkripsiRepository skripsiRepository) {
        this.skripsiRepository = skripsiRepository;
    }

    public List<Skripsi> getAll() {
        return skripsiRepository.findAll();
    }

    public Skripsi getById(Long id) {
        return skripsiRepository.findById(id).orElse(null);
    }

    public Skripsi save(Skripsi skripsi) {
        return skripsiRepository.save(skripsi);
    }

    public Skripsi update(Skripsi skripsi) {
        return skripsiRepository.save(skripsi);
    }

    public void delete(Long id) {
        skripsiRepository.deleteById(id);
    }

    public List<Skripsi> search(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            return skripsiRepository.findAll();
        }

        return skripsiRepository.findByJudulContainingIgnoreCase(keyword);
    }

}