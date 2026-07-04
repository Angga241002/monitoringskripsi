package com.monitoringskripsi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkripsiDTO {

    private Long id;

    private String judul;

    private String status;

    private String mahasiswa;

    private String dosen;

}