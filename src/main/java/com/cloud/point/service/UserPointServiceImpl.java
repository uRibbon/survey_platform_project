package com.cloud.point.service;

import com.cloud.point.dto.UserDTO;
import com.cloud.point.dto.UserPointDTO;
import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserPointServiceImpl implements UserPointService {

    @Autowired
    private final UserPointRepository userPointRepository;

    @Override
    public UserPointDTO getOneUserPoint(String userId) {
        UserPoint userPoint = userPointRepository.findByUserId(userId);
        UserPointDTO userPointDTO = entityToDTO(userPoint);
        return userPointDTO;
    }

    @Override
    public void updateUserPoint(String userId) {

        //UserPoint userPoint = userPointRepository.findByUserId(userId);
        userPointRepository.updateUserPoint(userId);
//        Integer userPointScore = userPoint.getUserPointScore();
//        userPointRepository.updateUserPoint();
        System.out.println("성공");

    }
}
