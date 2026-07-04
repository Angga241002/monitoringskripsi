package com.monitoringskripsi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dokumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaFile;

    private String filePath;

    @ManyToOne
    @JoinColumn(name = "progress_id")
    private Progress progress;
}