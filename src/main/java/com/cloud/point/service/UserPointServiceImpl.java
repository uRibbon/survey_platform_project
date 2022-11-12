package com.cloud.point.service;

import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserPointServiceImpl implements UserPointService {

    @Autowired
    private final UserPointRepository userPointRepository;

    @Override
    public UserPoint getOneUserPoint(String userId) {
        UserPoint userPoint = userPointRepository.findByUserId(userId);
        return userPoint;
    }
}
