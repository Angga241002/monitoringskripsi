package com.monitoringskripsi.dto;

public class ProgressDTO {

    private Long id;

    private String tanggal;

    private String kegiatan;

    private String status;

    private String komentarDosen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKomentarDosen() {
        return komentarDosen;
    }

    public void setKomentarDosen(String komentarDosen) {
        this.komentarDosen = komentarDosen;
    }
}