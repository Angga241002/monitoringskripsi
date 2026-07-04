package com.monitoringskripsi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgressDTO {

    private Long id;

    private String tanggal;

    private String kegiatan;

    private String status;

    private String komentarDosen;

}