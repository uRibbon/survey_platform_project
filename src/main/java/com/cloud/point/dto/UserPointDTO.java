package com.cloud.point.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPointDTO {
    private Integer id;
    private String userId;
    private Integer userPointScore;
}