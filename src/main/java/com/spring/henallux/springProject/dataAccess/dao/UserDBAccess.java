package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.UserEntity;
import com.spring.henallux.springProject.dataAccess.repository.UserRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public User saveUser(User user) {
        UserEntity userEntity = userRepository.save(providerConverter.userModelToUserEntity(user));
        return providerConverter.userEntityToUserModel(userEntity);
    }

    @Override
    public User findByUsername(String username) {
        UserEntity user =  userRepository.findByUsername(username);
        if (user != null)
            return providerConverter.userEntityToUserModel(user);
        else return null;
    }

    @Override
    public User findByEmail(String email) {
        UserEntity user =  userRepository.findByEmail(email);
        if (user != null)
            return providerConverter.userEntityToUserModel(user);
        else return null;
    }

    @Override
    public ArrayList<User> findAll() {
        return new ArrayList<>(userRepository.findAll()
                .stream()
                .map(userEntity -> providerConverter.userEntityToUserModel(userEntity))
                .toList());
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(providerConverter.userModelToUserEntity(user));
    }
}
