package com.cloud.survey.service;


import com.cloud.survey.dto.survey.SurveyDTO;
import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;

import java.util.List;

public interface SurveyService {

    List<SurveyDTO> getSurveyList(SurveyStatus status, IsYn isPrivateYn); // 설문조사 리스트 조회

    SurveyDTO getSurveyDetail (int surId); // 설문 상세정보 조회

    List<Survey> getBestSurvey(); // 카테고리별 인기 설문조사 조회

    default SurveyDTO entityToDTO(Survey survey) {
        SurveyDTO dto = SurveyDTO.builder()
                .surId(survey.getSurId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .categoryId(survey.getSurveyCategory().getSurCatId())
                .categoryContent(survey.getSurveyCategory().getContent())
                .version(survey.getVersion())
                .status(survey.getStatus())
                .dueDt(survey.getDueDt())
                .isLoginYn(survey.getIsLoginYn())
                .isPrivateYn(survey.getIsPrivateYn())
                .isModifyYn(survey.getIsModifyYn())
                .isAnnoyYn(survey.getIsAnnoyYn())
                .regId(survey.getRegId())
                .regDt(survey.getRegDt())
                .build();
        return dto;
    }
}
