package com.cloud.point.service;

import com.cloud.point.entity.PointHistory;

import java.util.List;

public interface PointHistoryService {
    // 전체 히스토리 조회
    List<PointHistory> getAllPointHistoryList();

    // pointHisNo에 따른 히스토리 조히
    PointHistory getOnePointHistory(Integer pointHisNo);
}
