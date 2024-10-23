package com.example.airspaceback.bpo;

import com.example.airspaceback.entity.Users;

import java.util.List;

/**
 * @author 吴泽瑞
 * @version 1.0
 * @date 2024-10-22 16:21
 */
public interface UserBPO {
    boolean register(Users user);

    Users login(String username, String password);
    List<Users> getAllUsers();
    boolean updateUserStatus(Long userId, String status);
    boolean updateUserRole(Long userId, String role);
    boolean deleteUser(Long userId);
}
