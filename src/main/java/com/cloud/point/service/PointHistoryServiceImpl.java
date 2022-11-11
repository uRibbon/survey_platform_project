package com.cloud.point.service;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.repository.PointHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PointHistoryServiceImpl implements PointHistoryService {
    public List<Object> getPointHistoryList(Integer pointHisNo) {

        @Autowired
        PointHistoryRepository pointHistoryRepository;

        @Override
        public PointHistory getPointHistoryList(PointHistory pointHistory) {
            PointHistory pointHistory1 = pointHistoryRepository.findById(pointHistory.getPointHisNo()).orElse(null);
            return pointHistory1;
        }
    }
}
