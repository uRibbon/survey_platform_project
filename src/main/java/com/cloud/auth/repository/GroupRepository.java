package com.cloud.auth.repository;

import com.cloud.auth.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
