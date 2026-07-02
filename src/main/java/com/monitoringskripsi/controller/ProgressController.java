package com.monitoringskripsi.controller;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.enums.StatusProgress;
import com.monitoringskripsi.repository.ProgressRepository;
import com.monitoringskripsi.repository.SkripsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dosen/progress")
public class ProgressController {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private SkripsiRepository skripsiRepository;

    // ============================
    // TAMPILKAN PROGRESS
    // ============================
    @GetMapping("/{skripsiId}")
    public String index(@PathVariable Long skripsiId, Model model) {

        List<Progress> list = progressRepository.findBySkripsiId(skripsiId);

        model.addAttribute("progressList", list);
        model.addAttribute("skripsiId", skripsiId);

        return "dosen/progress/index";
    }

    // ============================
    // FORM TAMBAH PROGRESS
    // ============================
    @GetMapping("/tambah/{skripsiId}")
    public String formTambah(@PathVariable Long skripsiId, Model model) {

        model.addAttribute("progress", new Progress());
        model.addAttribute("skripsiId", skripsiId);

        return "dosen/progress/form";
    }

    // ============================
    // SIMPAN PROGRESS
    // ============================
    @PostMapping("/simpan/{skripsiId}")
public String simpan(@PathVariable Long skripsiId,
                     @ModelAttribute Progress progress) {

    Skripsi skripsi = skripsiRepository.findById(skripsiId).orElse(null);

    if (skripsi == null) {
        return "redirect:/dosen/skripsi";
    }

    progress.setSkripsi(skripsi);

    // DEFAULT STATUS HARUS PROSES
    if (progress.getStatus() == null) {
        progress.setStatus(StatusProgress.PROSES);
    }

    progressRepository.save(progress);

    return "redirect:/dosen/progress/" + skripsiId;
}

    // ============================
    // ACC PROGRESS
    // ============================
    @GetMapping("/acc/{id}")
    public String acc(@PathVariable Long id) {

        Progress progress = progressRepository.findById(id).orElse(null);

        if (progress != null) {
            progress.setStatus(StatusProgress.ACC);
            progressRepository.save(progress);

            return "redirect:/dosen/progress/" + progress.getSkripsi().getId();
        }

        return "redirect:/dosen/dashboard";
    }

    // ============================
    // REVISI PROGRESS
    // ============================
    @GetMapping("/revisi/{id}")
    public String revisi(@PathVariable Long id) {

        Progress progress = progressRepository.findById(id).orElse(null);

        if (progress != null) {
            progress.setStatus(StatusProgress.REVISI);
            progressRepository.save(progress);

            return "redirect:/dosen/progress/" + progress.getSkripsi().getId();
        }

        return "redirect:/dosen/dashboard";
    }
}