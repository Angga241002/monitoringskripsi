package com.monitoringskripsi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByNim(String nim);

    User findByNim(String nim);

    List<User> findByRole(Role role);

    List<User> findByNamaContainingIgnoreCase(String nama);

List<User> findByNamaContainingIgnoreCaseAndRole(
        String nama,
        Role role);

}