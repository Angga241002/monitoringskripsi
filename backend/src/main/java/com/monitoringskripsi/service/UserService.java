package com.monitoringskripsi.service;

import java.util.List;
import java.util.Optional;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(User user);

    void deleteById(Long id);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByNim(String nim);

    User findByNim(String nim);

    List<User> findByRole(Role role);

    List<User> search(String keyword);

    List<User> searchMahasiswa(String keyword);


    long count();

}