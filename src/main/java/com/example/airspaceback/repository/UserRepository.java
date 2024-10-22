package com.example.airspaceback.repository;

import com.example.airspaceback.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // 可以添加自定义查询方法
    Users findByUsername(String username);
}