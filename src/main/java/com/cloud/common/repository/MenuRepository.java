package com.cloud.common.repository;

import com.cloud.common.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("select m from Menu m where m.pmenuId = 0 and m.useYn = true order by m.sortIdx asc")
    List<Menu> findLargeCategoryList();

    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.pmenuId <> 0 and m.useYn = true order by m.sortIdx asc")
    List<Menu> findMiddleCategoryList(Integer pmenuId);

    @Query("select m from Menu m where m.pmenuId = :pmenuId and m.useYn = true order by m.sortIdx asc")
    List<Menu> findSmallCategoryList(Integer pmenuId);
}
