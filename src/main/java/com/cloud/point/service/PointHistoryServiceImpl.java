package com.cloud.point.service;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.repository.PointHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointHistoryServiceImpl implements PointHistoryService {
    // repository 선언하기
    private final PointHistoryRepository pointHistoryRepository;

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
}
