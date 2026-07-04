package com.monitoringskripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;

@Repository
public interface DosenRepository extends JpaRepository<User, Long> {

    List<User> findByRole(Role role);

    List<User> findByRoleAndNamaContainingIgnoreCase(Role role, String nama);

}