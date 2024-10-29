package com.example.airspaceback.blo.impl;

import com.example.airspaceback.blo.AirspaceCapacityBLO;
import com.example.airspaceback.dto.AirspaceCapacityDTO;
import com.example.airspaceback.repository.AirspaceCapacityRepository;
import com.example.airspaceback.entity.AirspaceCapacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AirspaceCapacityBLOImpl implements AirspaceCapacityBLO {
    @Autowired private AirspaceCapacityRepository airspaceCapacityRepository;

    @Override public AirspaceCapacityDTO saveAirspaceCapacity(AirspaceCapacity airspaceCapacity) {
        AirspaceCapacity savedEntity = airspaceCapacityRepository.save(airspaceCapacity);
        return convertToDTO(savedEntity);
    }

    private AirspaceCapacityDTO convertToDTO(AirspaceCapacity entity) {
        return new AirspaceCapacityDTO(entity.getAvailableVolume(), entity.getSafetyInterval(),
            entity.getSafetyFactor(), entity.getRestrictedAirspaceRatio(), entity.getEfficiencyFactor(),
            entity.getAircraftVolume(), entity.getCalculatedCapacity(), entity.getMaxFlights(), entity.getCreateTime());
    }
}