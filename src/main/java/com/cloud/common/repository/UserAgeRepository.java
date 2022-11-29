package com.cloud.common.repository;

import com.cloud.common.entity.UserAge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgeRepository extends JpaRepository<UserAge, Integer> {
}
