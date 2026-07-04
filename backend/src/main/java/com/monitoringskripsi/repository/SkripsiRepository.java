package com.monitoringskripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitoringskripsi.entity.Skripsi;
import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.StatusSkripsi;

@Repository
public interface SkripsiRepository extends JpaRepository<Skripsi, Long> {

    List<Skripsi> findByMahasiswa(User mahasiswa);

    List<Skripsi> findByDosen(User dosen);

    boolean existsByMahasiswa(User mahasiswa);

    long countByStatus(StatusSkripsi status);

    List<Skripsi> findByJudulContainingIgnoreCase(String judul);

    Skripsi findFirstByMahasiswa(User mahasiswa);

}