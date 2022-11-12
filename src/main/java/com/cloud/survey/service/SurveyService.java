package com.cloud.survey.service;


import com.cloud.survey.dto.SurveyDTO;
import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.SurveyStatus;

import java.util.List;
public interface SurveyService {

    List<SurveyDTO> getSurveyList(SurveyStatus status, IsYn isPrivateYn); // 설문조사 리스트 조회

}
