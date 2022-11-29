package com.cloud.common.repository;

import com.cloud.common.entity.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJobRepository extends JpaRepository<UserJob, Integer> {
}
