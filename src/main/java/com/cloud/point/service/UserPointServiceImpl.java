package com.cloud.point.service;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserPointServiceImpl implements UserPointService {

    @Autowired
    private final UserPointRepository userPointRepository;

    @Override
    public UserPoint getOneUserPoint(Integer id) {
        UserPoint userPoint = userPointRepository.findById(id).orElse(null);
        return userPoint;
    }
}
