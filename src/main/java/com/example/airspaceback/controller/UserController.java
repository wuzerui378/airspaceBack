package com.example.airspaceback.controller;/**
 * @author 吴泽瑞
 * @date 2024-10-22 16:21
 * @version 1.0
 */

import com.example.airspaceback.bpo.UserBPO;
import com.example.airspaceback.dto.LoginResponseDTO;
import com.example.airspaceback.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserController
 * @Author : 吴泽瑞
 * @Date :2024/10/22  16:21
 * @Version :1.0
 */
@RestController
@RequestMapping("/airspace/users")
@CrossOrigin(origins = "http://localhost:3000",
    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
    allowCredentials = "true")
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
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Users user = userBpo.login(username, password);
        if (user != null) {
            LoginResponseDTO response = new LoginResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                user.getEmail(),
                user.getPhone()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("登录失败，用户名或密码错误");
        }
    }

    // 获取所有用户列表
    @GetMapping("/admin")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userBpo.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // 更新用户状态
    @PutMapping("/admin/status")
    public ResponseEntity<String> updateUserStatus(
        @RequestParam Long userId,
        @RequestParam String status) {
        boolean success = userBpo.updateUserStatus(userId, status);
        if (success) {
            return ResponseEntity.ok("用户状态更新成功");
        } else {
            return ResponseEntity.badRequest().body("用户状态更新失败");
        }
    }

    // 更新用户角色
    @PutMapping("/admin/role")
    public ResponseEntity<String> updateUserRole(
        @RequestParam Long userId,
        @RequestParam String role) {
        boolean success = userBpo.updateUserRole(userId, role);
        if (success) {
            return ResponseEntity.ok("用户角色更新成功");
        } else {
            return ResponseEntity.badRequest().body("用户角色更新失败");
        }
    }

    // 删除用户
    @DeleteMapping("/admin/delete")
    public ResponseEntity<String> deleteUser(@RequestParam Long userId) {
        boolean success = userBpo.deleteUser(userId);
        if (success) {
            return ResponseEntity.ok("用户删除成功");
        } else {
            return ResponseEntity.badRequest().body("用户删除失败");
        }
    }
}
