package com.example.airspaceback.bpo;

import com.example.airspaceback.dto.AirspaceCapacityDTO;
import com.example.airspaceback.entity.AirspaceCapacity;

import java.util.List;

public interface AirspaceCapacityBPO {
    AirspaceCapacityDTO saveAirspaceCapacity(AirspaceCapacityDTO airspaceCapacityDTO);

    // 添加查询所有记录的方法
    List<AirspaceCapacityDTO> findAllAirspaceCapacity();
}