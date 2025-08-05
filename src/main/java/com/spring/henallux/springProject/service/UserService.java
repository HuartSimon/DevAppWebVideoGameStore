package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.springProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDataAccess userDAO;

    public boolean isUsernameAlreadyTaken(String username) {
        return userDAO.findByUsername(username) != null;
    }
    public boolean isEmailAlreadyTaken(String email) {
        return userDAO.findByEmail(email) != null;
    }

    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }


}
