package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis_option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PlatformAnalysisOptionRepository extends JpaRepository<Platform_analysis_option, Integer> {

    @Modifying
    @Transactional
    @Query("update Platform_analysis_option PAO set PAO.value=PAO.value+1 where PAO.optionId=:optionId")
    void updateValue(Integer optionId);
}
