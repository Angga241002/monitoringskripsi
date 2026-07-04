package com.monitoringskripsi.entity;

import com.monitoringskripsi.enums.StatusSkripsi;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skripsi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String judul;

    @Enumerated(EnumType.STRING)
    private StatusSkripsi status;

    @ManyToOne
    @JoinColumn(name = "mahasiswa_id")
    private User mahasiswa;

    @ManyToOne
    @JoinColumn(name = "dosen_id")
    private User dosen;
}