package com.cloud.auth.repository;

import com.cloud.auth.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("select g from Group g where g.delYn='N'")
    List<Group> findExistGroup();

}
