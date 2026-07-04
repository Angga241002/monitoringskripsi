package com.monitoringskripsi.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;
import com.monitoringskripsi.service.UserService;

@RestController
@RequestMapping("/api/dosen")
@CrossOrigin(origins = {
        "http://localhost:5501",
        "http://127.0.0.1:5501"
})
public class DosenApiController {

    private final UserService userService;

    public DosenApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findByRole(Role.DOSEN);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {

        user.setRole(Role.DOSEN);

        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User user) {

        user.setId(id);
        user.setRole(Role.DOSEN);

        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}