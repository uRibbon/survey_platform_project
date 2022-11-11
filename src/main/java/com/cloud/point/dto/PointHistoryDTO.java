package com.cloud.point.dto;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.PointType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PointHistoryDTO {
    private Integer pointHisNo;
    private String userId;
    private PointType pointType;
    private String regId;
    private LocalDateTime regDt;
    private String modId;
    private LocalDateTime modDt;

    /*
    private List<PointHistoryDTO> pointHistoryList;

    public void addPointHistoryList(PointHistoryDTO pointHistoryDTO) {
        pointHistoryList.add(pointHistoryDTO);
    }*/
}
