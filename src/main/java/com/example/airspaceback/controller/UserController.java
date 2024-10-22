package com.example.airspaceback.controller;/**
 * @author 吴泽瑞
 * @date 2024-10-22 16:21
 * @version 1.0
 */

import com.example.airspaceback.bpo.UserBPO;
import com.example.airspaceback.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Author : 吴泽瑞
 * @Date :2024/10/22  16:21
 * @Version :1.0
 */
@RestController
@RequestMapping("/airspace/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserBPO userBpo;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        if (userBpo.register(user)) {
            return ResponseEntity.ok("注册成功");
        } else {
            return ResponseEntity.badRequest().body("注册失败，用户名可能已存在");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (userBpo.login(username, password)) {
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.badRequest().body("登录失败，用户名或密码错误");
        }
    }
}
