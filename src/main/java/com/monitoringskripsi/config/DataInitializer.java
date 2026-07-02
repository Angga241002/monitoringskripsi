package com.monitoringskripsi.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;
import com.monitoringskripsi.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.count() == 0) {

                User dosen = User.builder()
                        .username("dosen")
                        .password(passwordEncoder.encode("admin123"))
                        .role(Role.DOSEN)
                        .status(true)
                        .createdAt(LocalDateTime.now())
                        .build();

                User mahasiswa = User.builder()
                        .username("mahasiswa")
                        .password(passwordEncoder.encode("admin123"))
                        .role(Role.MAHASISWA)
                        .status(true)
                        .createdAt(LocalDateTime.now())
                        .build();

                userRepository.save(dosen);
                userRepository.save(mahasiswa);

                System.out.println("=================================");
                System.out.println("Default User Berhasil Dibuat");
                System.out.println("Username : dosen");
                System.out.println("Password : admin123");
                System.out.println("Username : mahasiswa");
                System.out.println("Password : admin123");
                System.out.println("=================================");
            }

        };

    }

}