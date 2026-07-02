package com.monitoringskripsi.repository;

import com.monitoringskripsi.entity.Progress;
import com.monitoringskripsi.enums.StatusProgress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findBySkripsiId(Long skripsiId);
    long countByStatus(StatusProgress status);

}