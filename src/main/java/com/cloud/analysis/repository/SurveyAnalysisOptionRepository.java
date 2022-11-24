package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SurveyAnalysisOptionRepository extends JpaRepository<Survey_analysis_option, Integer> {

    @Modifying
    @Transactional
    @Query("update Survey_analysis_option SAO set SAO.value=SAO.value+1 where SAO.optionId=:optionId")
    void updateValue(Integer optionId);
}
