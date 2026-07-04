package com.monitoringskripsi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.repository.SkripsiRepository;
import com.monitoringskripsi.service.SkripsiService;

@Service
public class SkripsiServiceImpl implements SkripsiService {

    private final SkripsiRepository skripsiRepository;

    public SkripsiServiceImpl(SkripsiRepository skripsiRepository) {
        this.skripsiRepository = skripsiRepository;
    }

    @Override
    public List<Skripsi> findAll() {
        return skripsiRepository.findAll();
    }

    @Override
    public Skripsi findById(Long id) {
        return skripsiRepository.findById(id).orElse(null);
    }

    @Override
    public Skripsi save(Skripsi skripsi) {
        return skripsiRepository.save(skripsi);
    }

    @Override
    public void deleteById(Long id) {
        skripsiRepository.deleteById(id);
    }

    @Override
    public long count() {
        return skripsiRepository.count();
    }

    @Override
    public List<Skripsi> search(String keyword) {
        return skripsiRepository.findByJudulContainingIgnoreCase(keyword);
    }
}