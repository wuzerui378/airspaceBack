package com.example.airspaceback.blo.impl;

import com.example.airspaceback.blo.AirspaceCapacityBLO;
import com.example.airspaceback.repository.AirspaceCapacityRepository;
import com.example.airspaceback.entity.AirspaceCapacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AirspaceCapacityBLOImpl implements AirspaceCapacityBLO {
    @Autowired
    private AirspaceCapacityRepository airspaceCapacityRepository;

    public AirspaceCapacity saveAirspaceCapacity(AirspaceCapacity airspaceCapacity) {
        airspaceCapacity.setCreateTime(LocalDateTime.now());
        return airspaceCapacityRepository.save(airspaceCapacity);
    }
}