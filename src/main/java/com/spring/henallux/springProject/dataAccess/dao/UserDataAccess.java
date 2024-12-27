package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.User;

import java.util.ArrayList;

public interface UserDataAccess {
    User saveUser(User user);
    User findByUsername(String username);
    ArrayList<User> findAll();
    User findByEmail(String email);
    void deleteUser(User user);
}
