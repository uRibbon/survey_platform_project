package com.cloud.point.repository;

import com.cloud.point.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPointRepository extends JpaRepository<UserPoint, Integer> {

}
