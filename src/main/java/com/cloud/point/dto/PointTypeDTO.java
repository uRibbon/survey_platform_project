package com.cloud.point.dto;


import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class PointTypeDTO {
    private Integer no;
    private String type;
    private Integer score;
    private String regId;
    private LocalDateTime regDt;
    private String modId;
    private LocalDateTime modDt;
}
