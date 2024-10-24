package com.example.airspaceback.bpo.impl;

import com.example.airspaceback.blo.AirspaceCapacityBLO;
import com.example.airspaceback.bpo.AirspaceCapacityBPO;
import com.example.airspaceback.entity.AirspaceCapacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirspaceCapacityBPOImpl implements AirspaceCapacityBPO {
    @Autowired
    private AirspaceCapacityBLO airspaceCapacityBLO;

    public AirspaceCapacity calculateAndSaveAirspaceCapacity(AirspaceCapacity airspaceCapacity) {
        // 计算空域容量
        double calculatedCapacity = calculateCapacity(airspaceCapacity);
        airspaceCapacity.setCalculatedCapacity(calculatedCapacity);

        return airspaceCapacityBLO.saveAirspaceCapacity(airspaceCapacity);
    }

    private double calculateCapacity(AirspaceCapacity airspaceCapacity) {
        // 根据给定的参数计算空域容量
        // 这里只是一个示例,实际计算逻辑需要根据具体需求实现
        double capacity = airspaceCapacity.getDelta_ij() * airspaceCapacity.getGamma() / airspaceCapacity.getSigma_o();
        return capacity;
    }
}