package com.monitoringskripsi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bimbingan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate tanggal;

    @Column(columnDefinition = "TEXT")
    private String catatanMahasiswa;

    @Column(columnDefinition = "TEXT")
    private String catatanDosen;

    @ManyToOne
    @JoinColumn(name = "skripsi_id")
    private Skripsi skripsi;
}