package com.monitoringskripsi.controller.api;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.service.ProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bimbingan")
@CrossOrigin(origins = "*")
public class BimbinganApiController {

    private final ProgressService progressService;

    public BimbinganApiController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public List<Progress> getAll() {
        return progressService.findAll();
    }

    @GetMapping("/{id}")
    public Progress getById(@PathVariable Long id) {
        return progressService.findById(id);
    }

    @PostMapping("/review/{id}")
    public Progress review(
            @PathVariable Long id,
            @RequestBody Progress progress) {

        Progress data = progressService.findById(id);

        data.setKomentarDosen(progress.getKomentarDosen());
        data.setStatus(progress.getStatus());

        return progressService.save(data);
    }
}