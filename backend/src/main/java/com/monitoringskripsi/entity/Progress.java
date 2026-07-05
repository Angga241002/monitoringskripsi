package com.monitoringskripsi.entity;

import com.monitoringskripsi.enums.StatusProgress;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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

    public Progress() {
    }

    public Progress(Long id, String kegiatan, LocalDate tanggal, StatusProgress status, String komentarDosen, Skripsi skripsi, String bab) {
        this.id = id;
        this.kegiatan = kegiatan;
        this.tanggal = tanggal;
        this.status = status;
        this.komentarDosen = komentarDosen;
        this.skripsi = skripsi;
        this.bab = bab;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public StatusProgress getStatus() {
        return status;
    }

    public void setStatus(StatusProgress status) {
        this.status = status;
    }

    public String getKomentarDosen() {
        return komentarDosen;
    }

    public void setKomentarDosen(String komentarDosen) {
        this.komentarDosen = komentarDosen;
    }

    public Skripsi getSkripsi() {
        return skripsi;
    }

    public void setSkripsi(Skripsi skripsi) {
        this.skripsi = skripsi;
    }

    public String getBab() {
        return bab;
    }

    public void setBab(String bab) {
        this.bab = bab;
    }
}