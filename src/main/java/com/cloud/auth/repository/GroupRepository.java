package com.cloud.auth.repository;

import com.cloud.auth.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("select g from Group g where g.delYn='N'")
    Page<Group> findExistGroup(Pageable pageable);

//    @Query(value="select g.*," +
//            "   if(g.reg_id = :userId, 'Y', 'N') is_mine," +
//            "   if(" +
//            "     (select count(g2.group_id)\n" +
//            "     from `group` g2 " +
//            "     where g2.group_id in (select ug.group_id from user_group ug where ug.user_id = :userId)" +
//            "     and g2.group_id = g.group_id) >0, 'Y', 'N') is_participate" +
//            "from `group` g " +
//            "where g.del_yn = 'N'", nativeQuery = true)
//    Page<Map<String,Object>> findExistGroupList(@Param("userId") String userId, Pageable pageable);
}
