package com.cloud.analysis.service;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis_option;

import java.util.List;

public interface AnalysisService {
    List<Survey_analysis_option> getSurveyAnalysisList(Integer surId);
    List<Platform_analysis_option> getPlatformAnalysisList(Integer surId);
}
