package com.abs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abs.entity.User;
import com.abs.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public User updateUser(Integer id, User user) {
        user.setId(id);
        return repo.save(user);
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }
}