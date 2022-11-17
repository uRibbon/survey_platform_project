package com.cloud.analysis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Survey_analysis_DTO {
    private Integer type;
    private String subject;

    private List<Survey_analysis_DTO> surveyAnalysisList;

    public void addOptionList(Survey_analysis_DTO survey_analysis_DTO) {
        surveyAnalysisList.add(survey_analysis_DTO);
    }
}
