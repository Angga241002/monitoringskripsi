package com.monitoringskripsi.controller;

import com.monitoringskripsi.repository.SkripsiRepository;
import com.monitoringskripsi.enums.StatusProgress;
import com.monitoringskripsi.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DosenController {

    @Autowired
    private SkripsiRepository skripsiRepository;

    @Autowired
    private ProgressRepository progressRepository;

    @GetMapping("/dosen/dashboard")
    public String dashboard(Model model) {

        long totalSkripsi = skripsiRepository.count();
        long totalProgress = progressRepository.count();

        long totalAcc = progressRepository.countByStatus(StatusProgress.ACC);
        long totalRevisi = progressRepository.countByStatus(StatusProgress.REVISI);
        long totalProses = progressRepository.countByStatus(StatusProgress.PROSES);

        model.addAttribute("totalSkripsi", totalSkripsi);
        model.addAttribute("totalProgress", totalProgress);
        model.addAttribute("totalAcc", totalAcc);
        model.addAttribute("totalRevisi", totalRevisi);
        model.addAttribute("totalProses", totalProses);

        return "dosen/dashboard";
    }
}