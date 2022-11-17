package com.cloud.analysis.service;

import com.cloud.analysis.dto.Platform_analysis_DTO;
import com.cloud.analysis.dto.Survey_analysis_DTO;
import com.cloud.analysis.entity.Platform_analysis;
import com.cloud.analysis.entity.Platform_analysis_option;
import com.cloud.analysis.entity.Survey_analysis;
import com.cloud.analysis.entity.Survey_analysis_option;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface AnalysisService {
    List<Survey_analysis_option> getSurveyAnalysisList(Integer surId);
    List<Platform_analysis_option> getPlatformAnalysisList(Integer surId);


    List<Object> getTypeSubjectList(Integer analysisId);

    default Platform_analysis_DTO TransferEntityToDTO(Platform_analysis platform_analysis) {
        Platform_analysis_DTO dto = Platform_analysis_DTO.builder()
                .type(platform_analysis.getType())
                .subject(platform_analysis.getSubject())
                .build();
        return dto;
    }

    default Survey_analysis_DTO TransferEntityToDTO(Survey_analysis survey_analysis) {
        Survey_analysis_DTO dto = Survey_analysis_DTO.builder()
                .type(survey_analysis.getType())
                .subject(survey_analysis.getSubject())
                .build();
        return dto;
    }
}

