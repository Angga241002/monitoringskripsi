package com.monitoringskripsi;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("dosen123     : " + encoder.encode("dosen123"));
        System.out.println("mahasiswa123 : " + encoder.encode("mahasiswa123"));

    }

}