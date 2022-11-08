package com.cloud.point.repository;

import com.cloud.point.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointRepository extends JpaRepository<UserPoint, String> {

}
