package com.monitoringskripsi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.service.SkripsiService;

@RestController
@RequestMapping("/api/skripsi")
@CrossOrigin(origins = {
        "http://127.0.0.1:5501",
        "http://localhost:5501"
})
public class SkripsiApiController {

    private final SkripsiService skripsiService;

    public SkripsiApiController(SkripsiService skripsiService) {
        this.skripsiService = skripsiService;
    }

    @GetMapping
    public List<Skripsi> getAll() {
        return skripsiService.findAll();
    }

    @GetMapping("/{id}")
    public Skripsi getById(@PathVariable Long id) {
        return skripsiService.findById(id);
    }

    @PostMapping
    public Skripsi save(@RequestBody Skripsi skripsi) {
        return skripsiService.save(skripsi);
    }

    @PutMapping("/{id}")
    public Skripsi update(@PathVariable Long id,
                          @RequestBody Skripsi skripsi) {

        skripsi.setId(id);

        return skripsiService.save(skripsi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skripsiService.deleteById(id);
    }

}