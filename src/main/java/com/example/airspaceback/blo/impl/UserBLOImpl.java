package com.example.airspaceback.blo.impl;

import com.example.airspaceback.blo.UserBLO;
import com.example.airspaceback.repository.UserRepository;
import com.example.airspaceback.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserBLOImpl implements UserBLO {
    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(Users user) {
        user.setCreateTime(LocalDateTime.now());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Users getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}