package com.example.airspaceback.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;  // 添加角色字段


    private String email;

    private String phone;

    private LocalDateTime createTime;

    private String status = "active";  // 默认状态为激活


}
