package com.monitoringskripsi.entity;

import com.monitoringskripsi.enums.StatusProgress;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kegiatan;

    private LocalDate tanggal;

    @Enumerated(EnumType.STRING)
    private StatusProgress status;

    @Column(columnDefinition = "TEXT")
    private String komentarDosen;

    @ManyToOne
    @JoinColumn(name = "skripsi_id")
    private Skripsi skripsi;

    private String bab;
}