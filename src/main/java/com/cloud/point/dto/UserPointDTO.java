package com.cloud.point.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserPointDTO {
    private Integer id;
    private String userId;
    private String userPointScore;
}