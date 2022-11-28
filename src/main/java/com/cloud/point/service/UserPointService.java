package com.cloud.point.service;

import com.cloud.point.dto.UserPointDTO;
import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserPointService {

    default UserPointDTO entityToDTO(UserPoint userPoint) {
        UserPointDTO userPointDTO = UserPointDTO.builder()
                .id(userPoint.getId())
                .userId(userPoint.getUserId())
                .userPointScore(userPoint.getUserPointScore())
                .build();
        return userPointDTO;
    }

    default UserPoint DTOtoEntity(UserPointDTO userPointdto) {
        UserPoint userPoint = UserPoint.builder()
                .id(userPointdto.getId())
                .userId(userPointdto.getUserId())
                .userPointScore(userPointdto.getUserPointScore())
                .build();
        return userPoint;
    }

    UserPointDTO getOneUserPoint(String userId);

    //사용자 포인트 update
    void updateUserPoint(String userId, String pointType);

}