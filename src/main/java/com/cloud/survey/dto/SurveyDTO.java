package com.cloud.survey.dto;

import com.cloud.survey.entity.SurveyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDTO {

    private int surId;
    private String description;
    private String category_id;
    private int version;
    private SurveyStatus status;
    private LocalDateTime dueDt;
    private String isLoginYn;
    private String isPrivateYn;
    private String isModifyYn;
    private String isAnnoyYn;
    private String regId;
    private LocalDateTime regDt;

}
