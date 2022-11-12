package com.cloud.point.repository;

import com.cloud.point.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPointRepository extends JpaRepository<UserPoint, Integer> {
    UserPoint findByUserId(@Param("userId") String userId);
}
