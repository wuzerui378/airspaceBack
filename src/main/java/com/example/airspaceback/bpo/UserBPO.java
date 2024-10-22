package com.example.airspaceback.bpo;

import com.example.airspaceback.entity.Users;

/**
 * @author 吴泽瑞
 * @version 1.0
 * @date 2024-10-22 16:21
 */
public interface UserBPO {
    boolean register(Users user);

    boolean login(String username, String password);
}
