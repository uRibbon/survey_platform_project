package com.cloud.point.repository;

import com.cloud.point.entity.UserPoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserPointRepositoryTest {
    @Autowired
    UserPointRepository userPointRepository;
    
    @Test
    void read() {
        List<UserPoint> userPointList = userPointRepository.findAll();
        userPointList.forEach(userPoint -> {
            System.out.println("userPoint = " + userPoint);
        });
    }
}