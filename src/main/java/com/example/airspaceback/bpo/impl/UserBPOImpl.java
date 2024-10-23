package com.example.airspaceback.bpo.impl;

import com.example.airspaceback.blo.UserBLO;
import com.example.airspaceback.bpo.UserBPO;
import com.example.airspaceback.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBPOImpl implements UserBPO {
    @Autowired
    private UserBLO userBlo;

    public boolean register(Users user) {
        // 检查用户名是否已存在
        if (userBlo.getUserByUsername(user.getUsername()) != null) {
            return false;
        }
        // 设置默认角色为普通用户
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        // 设置默认状态
        user.setStatus("ACTIVE");

        try {
            userBlo.saveUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Users login(String username, String password) {
        Users user = userBlo.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 检查用户状态
            if ("blocked".equals(user.getStatus())) {
                return null;  // 用户被封禁
            }
            return user;
        }
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return userBlo.getAllUsers();
    }

    @Override
    public boolean updateUserStatus(Long userId, String status) {
        Users user = userBlo.getUserById(userId);
        if (user != null) {
            user.setStatus(status);
            return userBlo.saveUser(user);
        }
        return false;
    }

    @Override
    public boolean updateUserRole(Long userId, String role) {
        Users user = userBlo.getUserById(userId);
        if (user != null) {
            user.setRole(role);
            return userBlo.saveUser(user);
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return userBlo.deleteUser(userId);
    }
}