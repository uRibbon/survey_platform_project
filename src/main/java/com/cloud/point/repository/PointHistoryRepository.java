package com.cloud.point.repository;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PointHistoryRepository extends JpaRepository<PointHistory, Integer> {
}
