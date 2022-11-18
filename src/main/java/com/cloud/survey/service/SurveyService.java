package com.cloud.survey.service;


import com.cloud.survey.dto.AnswerDTO;
import com.cloud.survey.dto.QuestionDTO;
import com.cloud.survey.dto.SurveyDTO;
import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;

import java.util.List;
import java.util.Map;

public interface SurveyService {

    List<SurveyDTO> getSurveyList(SurveyStatus status, IsYn isPrivateYn); // 설문조사 리스트 조회

    SurveyDTO getSurveyDetail (int surId); // 설문 상세정보 조회

    List<QuestionDTO> getSurveyQuestion (int surId); // 설문 질문 조회


    List<Survey> getBestSurvey(); // 카테고리별 인기 설문조사 조회
}
