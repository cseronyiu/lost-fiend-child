package com.example.lostfiendchild.service;

import com.example.lostfiendchild.entity.LostChildEntity;
import com.example.lostfiendchild.entity.UserEntity;
import com.example.lostfiendchild.repository.LostChildRepository;
import com.example.lostfiendchild.repository.UserRepository;
import com.example.lostfiendchild.viewModels.LostChildVM;
import com.example.lostfiendchild.viewModels.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser() {
        UserEntity userEntity = new UserEntity();
        userRepository.save(userEntity);
    }

    public void saveUser(UserVM user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setEmail(user.getEmail());
        userEntity.setOccupation(user.getOccupation());
        userEntity.setCompanyName(user.getCompanyName());
        userEntity.setCode(user.getCode());
        userEntity.setPassword(user.getPassword());
        userEntity.setVerifyPassword(user.getVerifyPassword());
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAllChild() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public List<UserEntity> getUserByEmailAndPassword(UserVM user){
        return userRepository.findAllByEmailAndPassword(user.getEmail(),user.getPassword());
    }
}