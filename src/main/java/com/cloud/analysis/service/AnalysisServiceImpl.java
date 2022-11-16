package com.cloud.analysis.service;

import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis_option;
import com.cloud.analysis.repository.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private final AnalysisRepository analysisRepository;

    @Override
    public List<Survey_analysis_option> getSurveyAnalysisList(Integer analysisId) {
        List<Survey_analysis_option> surveyAnalysisList = analysisRepository.findSurveyAnalysisByColumn(analysisId);
        return surveyAnalysisList;
    }

    @Override
    public List<Platform_analysis_option> getPlatformAnalysisList(Integer analysisId) {
        List<Platform_analysis_option> platformAnalysisList = analysisRepository.findPlatformAnalysisByColumn(analysisId);
        return platformAnalysisList;
    }
}
