package com.cloud.analysis.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SurveyDTO {
    private LocalDateTime regDt;
    private List<SurveyDTO> surveyList;

    public void addsurveyList(SurveyDTO surveyDTO) {
        surveyList.add(surveyDTO);
    }
}
