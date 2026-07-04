package com.monitoringskripsi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;
import com.monitoringskripsi.service.UserService;

@RestController
@RequestMapping("/api/mahasiswa")
@CrossOrigin(origins = {
        "http://127.0.0.1:5501",
        "http://localhost:5501"
})
public class MahasiswaApiController {

    private final UserService userService;

    public MahasiswaApiController(UserService userService) {
        this.userService = userService;
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

        return userService.save(user);
    }

    // ===========================
    // UPDATE
    // ===========================
    @PutMapping("/{id}")
    public User update(
            @PathVariable Long id,
            @RequestBody User user) {

        user.setId(id);
        user.setRole(Role.MAHASISWA);

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