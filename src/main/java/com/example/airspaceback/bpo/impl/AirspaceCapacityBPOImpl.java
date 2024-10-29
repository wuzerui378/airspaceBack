package com.example.airspaceback.bpo.impl;

import com.example.airspaceback.blo.AirspaceCapacityBLO;
import com.example.airspaceback.bpo.AirspaceCapacityBPO;
import com.example.airspaceback.dto.AirspaceCapacityDTO;
import com.example.airspaceback.entity.AirspaceCapacity;
import com.example.airspaceback.repository.AirspaceCapacityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirspaceCapacityBPOImpl implements AirspaceCapacityBPO {
    @Autowired
    private AirspaceCapacityBLO airspaceCapacityBLO;

    private final AirspaceCapacityRepository airspaceCapacityRepository;

    public AirspaceCapacityBPOImpl(AirspaceCapacityRepository airspaceCapacityRepository) {
        this.airspaceCapacityRepository = airspaceCapacityRepository;
    }

    @Override
    public AirspaceCapacityDTO saveAirspaceCapacity(AirspaceCapacityDTO airspaceCapacityDTO) {
        AirspaceCapacity entity = convertToEntity(airspaceCapacityDTO);
        return airspaceCapacityBLO.saveAirspaceCapacity(entity);
    }

    private AirspaceCapacity convertToEntity(AirspaceCapacityDTO dto) {
        AirspaceCapacity entity = new AirspaceCapacity();
        entity.setAvailableVolume(dto.getAvailableVolume());
        entity.setSafetyInterval(dto.getSafetyInterval());
        entity.setSafetyFactor(dto.getSafetyFactor());
        entity.setRestrictedAirspaceRatio(dto.getRestrictedAirspaceRatio());
        entity.setEfficiencyFactor(dto.getEfficiencyFactor());
        entity.setAircraftVolume(dto.getAircraftVolume());
        entity.setCalculatedCapacity(dto.getCalculatedCapacity());
        entity.setMaxFlights(dto.getMaxFlights());
        entity.setCreateTime(dto.getCreateTime() != null ? dto.getCreateTime() : LocalDateTime.now());
        return entity;
    }

    @Override
    public List<AirspaceCapacityDTO> findAllAirspaceCapacity() {
        // 使用JPA的findAll()方法查询所有记录
        return airspaceCapacityRepository.findAll().stream()
            .map(entity -> {
                AirspaceCapacityDTO dto = new AirspaceCapacityDTO();
                BeanUtils.copyProperties(entity, dto);
                return dto;
            })
            .collect(Collectors.toList());
    }

}