package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Platform_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformAnalysisRepository extends JpaRepository<Platform_analysis, Integer> {
}
