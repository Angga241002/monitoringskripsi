package com.monitoringskripsi.controller.api;

import com.monitoringskripsi.dto.LoginRequest;
import com.monitoringskripsi.dto.LoginResponse;
import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;
    private final PasswordEncoder encoder;

    public LoginController(UserService userService,
                           PasswordEncoder encoder) {

        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        User user = userService
                .findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {

            return new LoginResponse(
                    false,
                    null,
                    null,
                    "Username tidak ditemukan");
        }

        if (!encoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return new LoginResponse(
                    false,
                    null,
                    null,
                    "Password salah");
        }

        return new LoginResponse(

                true,

                user.getRole().name(),

                user.getNama(),

                "Login berhasil"

        );

    }

}