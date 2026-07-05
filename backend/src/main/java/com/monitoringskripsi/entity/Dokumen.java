package com.monitoringskripsi.entity;

import jakarta.persistence.*;

@Entity
public class Dokumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaFile;

    private String filePath;

    @ManyToOne
    @JoinColumn(name = "progress_id")
    private Progress progress;

    public Dokumen() {
    }

    public Dokumen(Long id, String namaFile, String filePath, Progress progress) {
        this.id = id;
        this.namaFile = namaFile;
        this.filePath = filePath;
        this.progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}