package com.monitoringskripsi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private boolean success;

    private String role;

    private String nama;

    private String message;

}