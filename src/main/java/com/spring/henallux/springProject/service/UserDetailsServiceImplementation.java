package com.spring.henallux.springProject.service;

import com.spring.henallux.springProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.springProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserDataAccess userDataAccess;

    @Autowired
    public UserDetailsServiceImplementation(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDataAccess.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found + (username: " + username + ")");

        return user;
    }
}
