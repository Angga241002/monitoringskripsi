package com.monitoringskripsi.dto;

public class SkripsiDTO {

    private Long id;

    private String judul;

    private String status;

    private String mahasiswa;

    private String dosen;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(String mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }
}