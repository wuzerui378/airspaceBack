package com.example.airspaceback.blo;

import com.example.airspaceback.entity.Users;

/**
 * @author 吴泽瑞
 * @date 2024-10-22 16:21
 * @version 1.0
 */
public interface UserBLO {
    boolean saveUser(Users user);
    Users getUserByUsername(String username);
}
