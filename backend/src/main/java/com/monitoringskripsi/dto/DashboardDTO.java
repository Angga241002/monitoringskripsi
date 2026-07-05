package com.monitoringskripsi.dto;

public class DashboardDTO {

    private int totalMahasiswa;

    private int totalSkripsi;

    private int totalProgress;

    private int totalBimbingan;

    public int getTotalMahasiswa() {
        return totalMahasiswa;
    }

    public void setTotalMahasiswa(int totalMahasiswa) {
        this.totalMahasiswa = totalMahasiswa;
    }

    public int getTotalSkripsi() {
        return totalSkripsi;
    }

    public void setTotalSkripsi(int totalSkripsi) {
        this.totalSkripsi = totalSkripsi;
    }

    public int getTotalProgress() {
        return totalProgress;
    }

    public void setTotalProgress(int totalProgress) {
        this.totalProgress = totalProgress;
    }

    public int getTotalBimbingan() {
        return totalBimbingan;
    }

    public void setTotalBimbingan(int totalBimbingan) {
        this.totalBimbingan = totalBimbingan;
    }
}