package com.example.airspaceback.dto;/**
 * @author 吴泽瑞
 * @date 2024-10-29 14:50
 * @version 1.0
 */

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName: AirspaceCapacityDTO
 * @Author : 吴泽瑞
 * @Date :2024/10/29  14:50
 * @Version :1.0
 */

@Data
@NoArgsConstructor  // 添加无参构造函数
@AllArgsConstructor
public class AirspaceCapacityDTO {
    private Double availableVolume;
    private Double safetyInterval;
    private Double safetyFactor;
    private Double restrictedAirspaceRatio;
    private Double efficiencyFactor;
    private Double aircraftVolume;
    // 计算结果
    private Double calculatedCapacity;
    private int maxFlights;
    private LocalDateTime createTime;
}
