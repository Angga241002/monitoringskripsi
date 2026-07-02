package com.monitoringskripsi.service;

import java.util.Optional;

import com.monitoringskripsi.entity.User;

public interface UserService {

    User save(User user);

    Optional<User> findByUsername(String username);

}