package com.monitoringskripsi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.service.ProgressService;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = {
        "http://127.0.0.1:5501",
        "http://localhost:5501"
})
public class ProgressApiController {

    private final ProgressService progressService;

    public ProgressApiController(ProgressService progressService) {
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

    @PostMapping
    public Progress save(@RequestBody Progress progress) {
        return progressService.save(progress);
    }

    @PutMapping("/{id}")
    public Progress update(@PathVariable Long id,
                           @RequestBody Progress progress) {

        progress.setId(id);

        return progressService.save(progress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        progressService.deleteById(id);
    }

}