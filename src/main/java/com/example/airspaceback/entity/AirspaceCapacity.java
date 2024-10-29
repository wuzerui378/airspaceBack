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
    private Double availableVolume;

    @Column(nullable = false)
    private Double safetyInterval;

    @Column(nullable = false)
    private Double safetyFactor;

    @Column(nullable = false)
    private Double restrictedAirspaceRatio;

    @Column(nullable = false)
    private Double efficiencyFactor;

    @Column(nullable = false)
    private Double aircraftVolume;

    // 计算结果
    private Double calculatedCapacity;

    private int maxFlights;

    // 添加其他必要的字段,如创建时间、修改时间等
    private LocalDateTime createTime;


}