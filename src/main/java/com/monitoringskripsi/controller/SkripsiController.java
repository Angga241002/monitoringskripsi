package com.monitoringskripsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.monitoringskripsi.service.SkripsiService;

@Controller
public class SkripsiController {

    private final SkripsiService skripsiService;

    public SkripsiController(SkripsiService skripsiService) {
        this.skripsiService = skripsiService;
    }

    @GetMapping("/dosen/skripsi")
    public String index(Model model) {

        model.addAttribute("skripsiList", skripsiService.getAll());

        return "dosen/skripsi/index";
    }

}