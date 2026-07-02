package com.monitoringskripsi.entity;

import com.monitoringskripsi.enums.StatusProgress;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skripsi_id", nullable =false)
    private Skripsi skripsi;

    private String bab;

    @Column(name = "judul_progress")
    private String judulProgress;

    private Integer persentase;

    @Column(columnDefinition = "TEXT")
    private String catatan;

    private LocalDate tanggal;

    @Enumerated(EnumType.STRING)
    private StatusProgress status;
}