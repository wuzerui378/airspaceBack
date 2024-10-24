package com.example.airspaceback.repository;

import com.example.airspaceback.entity.AirspaceCapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirspaceCapacityRepository extends JpaRepository<AirspaceCapacity, Long> {
    // 可以添加自定义查询方法
}