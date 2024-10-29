package com.example.airspaceback.controller;/**
 * @author 吴泽瑞
 * @date 2024-10-24 09:57
 * @version 1.0
 */

import com.example.airspaceback.bpo.AirspaceCapacityBPO;
import com.example.airspaceback.dto.AirspaceCapacityDTO;
import com.example.airspaceback.entity.AirspaceCapacity;
import com.example.airspaceback.repository.AirspaceCapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> calculateAndSaveCapacity(@RequestBody AirspaceCapacityDTO airspaceCapacityDTO) {
        try {
            // 设置创建时间
            airspaceCapacityDTO.setCreateTime(LocalDateTime.now());

            // 保存数据并返回结果
            AirspaceCapacityDTO savedDTO = airspaceCapacityBPO.saveAirspaceCapacity(airspaceCapacityDTO);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", savedDTO);
            response.put("message", "空域容量计算成功并保存");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "计算或保存过程中发生错误: " + e.getMessage());

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllCapacityRecords() {
        try {
            // 获取所有记录
            List<AirspaceCapacityDTO> records = airspaceCapacityBPO.findAllAirspaceCapacity();

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", records);
            response.put("message", "空域容量记录获取成功");
            response.put("total", records.size());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "获取记录过程中发生错误: " + e.getMessage());

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }


}
