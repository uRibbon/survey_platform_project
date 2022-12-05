package com.cloud.point.repository;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.PointType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PointTypeRepositoryTest {
    @Autowired
    PointTypeRepository pointTypeRepository;

    @Test
     void read() {
        List<PointType> pointTypeList = pointTypeRepository.findAll();
        pointTypeList.forEach(pointType -> {
            System.out.println("pointType = " + pointType);
        });
    }
}