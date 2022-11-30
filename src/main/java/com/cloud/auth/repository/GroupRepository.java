package com.cloud.auth.repository;

import com.cloud.auth.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("select g from Group g where g.delYn='N'")
    Page<Group> findExistGroup(Pageable pageable);

    // 그룹 삭제 처리
    @Modifying
    @Transactional
    @Query(value = "UPDATE Group g SET g.delYn = 'Y' WHERE g.groupId =:groupId")
    void updateGroupDelY(Integer groupId);


    @Query(value = "SELECT g FROM Group g WHERE (g.user.userId = :userId) AND (g.delYn = 'N')")
    Group findByUserId(String userId);

    // 그룹 참여자 추가
    @Modifying
    @Transactional
    @Query("UPDATE Group g SET g.groupCnt = g.groupCnt + 1 WHERE g.groupId =:groupId")
    void updateGroupCnt(Integer groupId);

}
