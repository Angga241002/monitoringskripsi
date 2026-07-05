package com.monitoringskripsi.entity;

import com.monitoringskripsi.enums.StatusSkripsi;
import jakarta.persistence.*;

@Entity
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

    public Skripsi() {
    }

    public Skripsi(Long id, String judul, StatusSkripsi status, User mahasiswa, User dosen) {
        this.id = id;
        this.judul = judul;
        this.status = status;
        this.mahasiswa = mahasiswa;
        this.dosen = dosen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public StatusSkripsi getStatus() {
        return status;
    }

    public void setStatus(StatusSkripsi status) {
        this.status = status;
    }

    public User getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(User mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public User getDosen() {
        return dosen;
    }

    public void setDosen(User dosen) {
        this.dosen = dosen;
    }
}