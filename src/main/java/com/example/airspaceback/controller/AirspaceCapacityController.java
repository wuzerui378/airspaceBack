package com.example.airspaceback.controller;/**
 * @author 吴泽瑞
 * @date 2024-10-24 09:57
 * @version 1.0
 */

import com.example.airspaceback.bpo.AirspaceCapacityBPO;
import com.example.airspaceback.entity.AirspaceCapacity;
import com.example.airspaceback.repository.AirspaceCapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: AirspaceCapacityController
 * @Author : 吴泽瑞
 * @Date :2024/10/24  09:57
 * @Version :1.0
 */
@RestController
@RequestMapping("/airspace/airspaceCapacity")
@CrossOrigin(origins = "http://localhost:3000",
    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE},
    allowCredentials = "true")
public class AirspaceCapacityController {
    @Autowired
    private AirspaceCapacityBPO airspaceCapacityBPO;

    @PostMapping("/calculate")
    public ResponseEntity<AirspaceCapacity> calculateAirspaceCapacity(@RequestBody AirspaceCapacity airspaceCapacity) {
        try {
            AirspaceCapacity result = airspaceCapacityBPO.calculateAndSaveAirspaceCapacity(airspaceCapacity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


}
