package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.repository.UserRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDBAccess implements UserDataAccess{

    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDBAccess(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(providerConverter.userModelToUserEntity(user));
    }

    @Override
    public User findByUsername(String username) {
        return providerConverter.userEntityToUserModel(userRepository.findByUsername(username));
    }

}
