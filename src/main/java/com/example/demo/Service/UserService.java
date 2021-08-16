package com.example.demo.Service;

import com.example.demo.DTO.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> save(User user);

    List<User> saveAll(List<User> users);

    Optional<User> get(Long id);

    List<User> getAll();

    List<User> getAllById(List<Long> ids);

    Boolean deleteById(Long id);

    Boolean delete(User user);

    Boolean deleteAll(List<User> users);

    Boolean deleteAll();
}