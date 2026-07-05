package com.monitoringskripsi.dto;

public class LoginResponse {

    private boolean success;

    private String role;

    private String nama;

    private String message;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String role, String nama, String message) {
        this.success = success;
        this.role = role;
        this.nama = nama;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}