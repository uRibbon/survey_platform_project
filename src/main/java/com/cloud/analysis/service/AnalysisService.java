package com.cloud.analysis.service;

import com.cloud.analysis.entity.Survey_analysis_option;

import java.util.List;

public interface AnalysisService {
    List<Survey_analysis_option> getAnalysisList(Integer surId);
}
