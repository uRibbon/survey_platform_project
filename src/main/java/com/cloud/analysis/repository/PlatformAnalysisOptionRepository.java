package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis_option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformAnalysisOptionRepository extends JpaRepository<Platform_analysis_option, Integer> {
}
