package com.cloud.point.repository;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.entity.PointType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointHistoryRepository extends JpaRepository<PointHistory, Integer> {
}
