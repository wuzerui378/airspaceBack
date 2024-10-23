package com.example.airspaceback.dto;/**
 * @author 吴泽瑞
 * @date 2024-10-23 14:00
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName: LoginResponseDTO
 * @Author : 吴泽瑞
 * @Date :2024/10/23  14:00
 * @Version :1.0
 */
@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String username;
    private String role;
    private String email;
    private String phone;
}