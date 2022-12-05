package com.cloud.analysis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Platform_analysis_DTO {
    private Integer type;
    private String subject;

    private List<Platform_analysis_DTO> platformAnalysisList;

    public void addOptionList(Platform_analysis_DTO platform_analysis_DTO) {
        platformAnalysisList.add(platform_analysis_DTO);
    }
}
