package com.cloud.point.repository;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.PointType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PointHistoryRepositoryTest {
    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @Autowired
    PointTypeRepository pointTypeRepository;

    @Test
    void read() {
        List<PointHistory> pointHistoryList = pointHistoryRepository.findAll();
        pointHistoryList.forEach(pointHistory -> {
            System.out.println("pointHistory = " + pointHistory);
        });
    }

    @Test
    void insert() {
        PointType pointType = PointType.builder()
                .no(2)
                .type("D")
                .score(50)
                .regId("Stella")
                .regDt(LocalDateTime.now())
                .modId("Sally")
                .modDt(LocalDateTime.now())
                .build();
        pointTypeRepository.save(pointType);
        PointHistory pointHistory = PointHistory.builder()
                .pointHisNo(2)
                .userId("2")
                .pointType(pointType)
                .regId("John")
                .regDt(LocalDateTime.now())
                .modId("Daisy")
                .modDt(LocalDateTime.now())
                .build();
        pointHistoryRepository.save(pointHistory);
    }
}