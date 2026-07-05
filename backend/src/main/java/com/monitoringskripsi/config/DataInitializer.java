package com.monitoringskripsi.config;

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

                User dosen = new User();
                dosen.setUsername("dosen");
                dosen.setPassword(passwordEncoder.encode("admin123"));
                dosen.setRole(Role.DOSEN);
                dosen.setStatus(true);

                User mahasiswa = new User();
                mahasiswa.setUsername("mahasiswa");
                mahasiswa.setPassword(passwordEncoder.encode("admin123"));
                mahasiswa.setRole(Role.MAHASISWA);
                mahasiswa.setStatus(true);

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