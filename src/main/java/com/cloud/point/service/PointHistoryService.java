package com.cloud.point.service;

import com.cloud.point.dto.PointHistoryDTO;
import com.cloud.point.dto.UserPointDTO;
import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.UserPoint;

import java.awt.*;
import java.util.List;

public interface PointHistoryService {
    // 전체 히스토리 조회
    List<PointHistory> getAllPointHistoryList();

    // pointHisNo에 따른 히스토리 조회
    PointHistory getOnePointHistory(Integer pointHisNo);

//    default PointHistory dtoToEntity(PointHistoryDTO pointHistoryDTO) {
//        PointHistory pointHistory = PointHistory.builder()
//                .pointHisNo(pointHistoryDTO.getPointHisNo())
//                .userId(pointHistoryDTO.getUserId())
//                .pointType(pointHistoryDTO.getPointType())
//                .regId(pointHistoryDTO.getRegId())
//                .regDt(pointHistoryDTO.getRegDt())
//                .modId(pointHistoryDTO.getModId())
//                .modDt(pointHistoryDTO.getModDt())
//                .build();
//        return pointHistory;
//    }


    void insertPointHistory(String userId, String pointType);
}
