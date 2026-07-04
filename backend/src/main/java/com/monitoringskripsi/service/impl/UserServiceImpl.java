package com.monitoringskripsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monitoringskripsi.entity.User;
import com.monitoringskripsi.enums.Role;
import com.monitoringskripsi.repository.UserRepository;
import com.monitoringskripsi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByNim(String nim) {
        return userRepository.existsByNim(nim);
    }

    @Override
    public User findByNim(String nim) {
        return userRepository.findByNim(nim);
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.findByNamaContainingIgnoreCase(keyword);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public List<User> searchMahasiswa(String keyword) {

        return userRepository.findAll()
                .stream()
                .filter(user ->
                        user.getRole().name().equals("MAHASISWA"))
                .filter(user ->
                        keyword == null
                        || keyword.isBlank()
                        || user.getNama().toLowerCase()
                            .contains(keyword.toLowerCase()))
                .toList();

    }

}