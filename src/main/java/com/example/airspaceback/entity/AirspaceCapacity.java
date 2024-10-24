package com.example.airspaceback.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "airspaceCapacity")
public class AirspaceCapacity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double delta_ij;

    @Column(nullable = false)
    private Double gamma;

    @Column(nullable = false)
    private Double sigma_o;

    @Column(nullable = false)
    private Double pv;

    @Column(nullable = false)
    private Double Tm;

    // 计算结果
    private Double calculatedCapacity;

    // 添加其他必要的字段,如创建时间、修改时间等
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}