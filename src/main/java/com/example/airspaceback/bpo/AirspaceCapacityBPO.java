package com.example.airspaceback.bpo;

import com.example.airspaceback.entity.AirspaceCapacity;

public interface AirspaceCapacityBPO {
    AirspaceCapacity calculateAndSaveAirspaceCapacity(AirspaceCapacity airspaceCapacity);
}