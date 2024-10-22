package com.example.airspaceback.bpo.impl;

import com.example.airspaceback.blo.UserBLO;
import com.example.airspaceback.bpo.UserBPO;
import com.example.airspaceback.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBPOImpl implements UserBPO {
    @Autowired
    private UserBLO userBlo;

    public boolean register(Users user) {
        // 检查用户名是否已存在
        if (userBlo.getUserByUsername(user.getUsername()) != null) {
            return false;
        }

        return userBlo.saveUser(user);
    }

    public boolean login(String username, String password) {
        Users user = userBlo.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        // 注意：这里应该添加密码验证逻辑
        return user.getPassword().equals(password);
    }
}