package com.monitoringskripsi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MonitoringskripsiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringskripsiApplication.class, args);
    }

    @Bean
    CommandLineRunner passwordGenerator() {
        return args -> {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            System.out.println("====================================");
            System.out.println("DOSEN      : " + encoder.encode("dosen123"));
            System.out.println("MAHASISWA  : " + encoder.encode("mahasiswa123"));
            System.out.println("====================================");

        };
    }
}