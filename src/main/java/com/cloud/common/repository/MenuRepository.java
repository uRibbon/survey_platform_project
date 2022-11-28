package com.cloud.common.repository;

import com.cloud.common.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    // Large Category List
    @Query("select m from Menu m where m.pmenuId = 0 and m.useYn = true and m.userRole <> 'ADMIN' order by m.sortIdx asc")
    List<Menu> findLargeUserCategoryList();

    @Query("select m from Menu m where m.pmenuId = 0 and m.useYn = true order by m.sortIdx asc")
    List<Menu> findLargeAdminCategoryList();

    @Query("select m from Menu m where m.pmenuId = 0 and m.useYn = true and m.userRole='ALL' order by m.sortIdx asc")
    List<Menu> findLargeAllCategoryList();

    // Middle Category List
    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.pmenuId <> 0 and m.useYn = true and m.userRole <> 'ADMIN' order by m.sortIdx asc")
    List<Menu> findMiddleUserCategoryList(Integer pmenuId);

    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.pmenuId <> 0 and m.useYn = true order by m.sortIdx asc")
    List<Menu> findMiddleAdminCategoryList(Integer pmenuId);

    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.pmenuId <> 0 and m.useYn = true and m.userRole='ALL' order by m.sortIdx asc")
    List<Menu> findMiddleAllCategoryList(Integer pmenuId);

    // Small Category List
    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.useYn = true and m.userRole <> 'ADMIN' order by m.sortIdx asc")
    List<Menu> findSmallUserCategoryList(Integer pmenuId);

    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.useYn = true order by m.sortIdx asc")
    List<Menu> findSmallAdminCategoryList(Integer pmenuId);

    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.useYn = true and m.userRole='ALL' order by m.sortIdx asc")
    List<Menu> findSmallAllCategoryList(Integer pmenuId);
}
