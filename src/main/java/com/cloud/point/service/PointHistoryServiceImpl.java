package com.cloud.point.service;

import com.cloud.point.dto.PointHistoryDTO;
import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.PointType;
import com.cloud.point.repository.PointHistoryRepository;
import com.cloud.point.repository.PointTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointHistoryServiceImpl implements PointHistoryService {
    // repository 선언하기
    private final PointHistoryRepository pointHistoryRepository;

    private final PointTypeRepository pointTypeRepository;

    @Override
    public List<PointHistory> getAllPointHistoryList() {
        List<PointHistory> pointHistoryList = pointHistoryRepository.findAll();
        return pointHistoryList;
    }

    @Override
    public PointHistory getOnePointHistory(Integer pointHisNo) {
        PointHistory pointHistory = pointHistoryRepository.findById(pointHisNo).orElse(null);
        return pointHistory;
    }
    @Override
    public void insertPointHistory(String userId, String pointType) {
        PointHistory pointHistory = PointHistory.builder()
                .userId(userId)
                .regId(userId)
                .regDt(LocalDateTime.now())
                .build();
        if(pointType.equals("E")) {
            pointHistory.setPointType(pointTypeRepository.findById(1).orElse(null));
        }
        else if(pointType.equals("D")) {
            pointHistory.setPointType(pointTypeRepository.findById(2).orElse(null));
        }
        else {
            pointHistory.setPointType(pointTypeRepository.findById(3).orElse(null));
        }
        pointHistoryRepository.save(pointHistory);
    }
}
