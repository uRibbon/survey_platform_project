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
                .no(1)
                .type("E")
                .score(50)
                .regId("YR")
                .regDt(LocalDateTime.now())
                .modId("YN")
                .modDt(LocalDateTime.now())
                .build();
        pointTypeRepository.save(pointType);
        PointHistory pointHistory = PointHistory.builder()
                .pointHisNo(1)
                .userId("1")
                .pointType(pointType)
                .regId("YJ")
                .regDt(LocalDateTime.now())
                .modId("SB")
                .modDt(LocalDateTime.now())
                .build();
        pointHistoryRepository.save(pointHistory);
    }
}