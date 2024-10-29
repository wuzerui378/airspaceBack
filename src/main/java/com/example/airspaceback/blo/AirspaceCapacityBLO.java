package com.example.airspaceback.blo;

import com.example.airspaceback.dto.AirspaceCapacityDTO;
import com.example.airspaceback.entity.AirspaceCapacity;

/**
 * @author 吴泽瑞
 * @version 1.0
 * @date 2024-10-24 09:54
 */
public interface AirspaceCapacityBLO {
    AirspaceCapacityDTO saveAirspaceCapacity(AirspaceCapacity airspaceCapacity);
}