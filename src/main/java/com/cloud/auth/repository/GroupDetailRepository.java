package com.cloud.auth.repository;

import com.cloud.auth.entity.GroupDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GroupDetailRepository extends JpaRepository<GroupDetail, Integer> {
    GroupDetail findByGroupId(Integer groupId);
}
