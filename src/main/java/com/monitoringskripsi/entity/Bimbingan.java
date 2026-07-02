package com.monitoringskripsi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bimbingan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bimbingan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "progress_id", nullable = false)
    private Progress progress;

    @Column(name = "komentar_mahasiswa", columnDefinition = "TEXT")
    private String komentarMahasiswa;

    @Column(name = "komentar_dosen", columnDefinition = "TEXT")
    private String komentarDosen;

    private LocalDateTime tanggal;

    @PrePersist
    public void prePersist() {
        tanggal = LocalDateTime.now();
    }

}