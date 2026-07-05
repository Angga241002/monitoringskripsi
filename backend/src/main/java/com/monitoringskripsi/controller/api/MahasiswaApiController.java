package com.monitoringskripsi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;
import com.monitoringskripsi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaApiController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public MahasiswaApiController(UserService userService,
                                  PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // ===========================
    // GET ALL MAHASISWA
    // ===========================
    @GetMapping
    public List<User> getAllMahasiswa() {
        return userService.findByRole(Role.MAHASISWA);
    }

    // ===========================
    // GET BY ID
    // ===========================
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // ===========================
    // SEARCH
    // ===========================
    @GetMapping("/search")
    public List<User> search(
            @RequestParam String keyword) {

        return userService.searchMahasiswa(keyword);
    }

    // ===========================
    // INSERT
    // ===========================
    @PostMapping
    public User save(@RequestBody User user) {

        user.setRole(Role.MAHASISWA);

        // ensure required fields for persistence
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            // default username from nim when available
            if (user.getNim() != null && !user.getNim().isBlank()) {
                user.setUsername(user.getNim());
            } else {
                user.setUsername("mhs" + System.currentTimeMillis());
            }
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode("password123"));
        }

        return userService.save(user);
    }

    // ===========================
    // UPDATE
    // ===========================
    @PutMapping("/{id}")
    public User update(
            @PathVariable Long id,
            @RequestBody User user) {
        // preserve id and role
        user.setId(id);
        user.setRole(Role.MAHASISWA);

        // fetch existing to preserve fields not present in request
        User existing = userService.findById(id);
        if (existing == null) {
            return null;
        }

        // username defaulting if blank
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            if (user.getNim() != null && !user.getNim().isBlank()) {
                user.setUsername(user.getNim());
            } else {
                user.setUsername(existing.getUsername());
            }
        }

        // preserve password when not provided; encode when provided
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            user.setPassword(existing.getPassword());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userService.update(user);
    }

    // ===========================
    // DELETE
    // ===========================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        userService.deleteById(id);

    }

}