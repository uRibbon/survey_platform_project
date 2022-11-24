package com.cloud.point.repository;

import com.cloud.point.dto.UserPointDTO;
import com.cloud.point.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPointRepository extends JpaRepository<UserPoint, Integer> {
    UserPoint findByUserId(@Param("userId") String userId);

    @Query(value = "UPDATE UserPoint up SET up.userPointScore = :pointScore WHERE up.userId = :userId")
    void updateUserPoint(Integer pointScore, String userId);

}
