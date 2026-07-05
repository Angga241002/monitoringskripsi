package com.monitoringskripsi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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

    public Bimbingan() {
    }

    public Bimbingan(Long id, LocalDate tanggal, String catatanMahasiswa, String catatanDosen, Skripsi skripsi) {
        this.id = id;
        this.tanggal = tanggal;
        this.catatanMahasiswa = catatanMahasiswa;
        this.catatanDosen = catatanDosen;
        this.skripsi = skripsi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getCatatanMahasiswa() {
        return catatanMahasiswa;
    }

    public void setCatatanMahasiswa(String catatanMahasiswa) {
        this.catatanMahasiswa = catatanMahasiswa;
    }

    public String getCatatanDosen() {
        return catatanDosen;
    }

    public void setCatatanDosen(String catatanDosen) {
        this.catatanDosen = catatanDosen;
    }

    public Skripsi getSkripsi() {
        return skripsi;
    }

    public void setSkripsi(Skripsi skripsi) {
        this.skripsi = skripsi;
    }
}