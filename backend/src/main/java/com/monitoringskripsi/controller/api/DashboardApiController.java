package com.monitoringskripsi.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitoringskripsi.enums.StatusProgress;
import com.monitoringskripsi.service.ProgressService;
import com.monitoringskripsi.service.SkripsiService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = {
        "http://localhost:5501",
        "http://127.0.0.1:5501"
})
public class DashboardApiController {

    private final SkripsiService skripsiService;
    private final ProgressService progressService;

    public DashboardApiController(
            SkripsiService skripsiService,
            ProgressService progressService) {

        this.skripsiService = skripsiService;
        this.progressService = progressService;
    }

    @GetMapping("/dosen")
    public Map<String, Object> dashboard() {

        Map<String, Object> result = new HashMap<>();

        result.put("totalSkripsi", skripsiService.count());

        result.put("totalProgress", progressService.findAll().size());

        result.put("totalAcc",

                progressService.findAll()
                        .stream()
                        .filter(p -> p.getStatus() == StatusProgress.ACC)
                        .count());

        result.put("totalRevisi",

                progressService.findAll()
                        .stream()
                        .filter(p -> p.getStatus() == StatusProgress.REVISI)
                        .count());

        result.put("totalProses",

                progressService.findAll()
                        .stream()
                        .filter(p -> p.getStatus() == StatusProgress.PROSES)
                        .count());

        return result;
    }

}