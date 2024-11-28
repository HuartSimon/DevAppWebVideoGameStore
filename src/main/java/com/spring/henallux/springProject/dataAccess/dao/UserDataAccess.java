package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.model.User;

public interface UserDataAccess {
    void saveUser(User user);
    User findByUsername(String username);
}
