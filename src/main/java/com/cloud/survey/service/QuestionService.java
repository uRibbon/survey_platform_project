package com.cloud.survey.service;

import com.cloud.survey.dto.QuestionDTO;
import com.cloud.survey.entity.Question;
import com.cloud.survey.entity.QuestionOption;

import java.util.ArrayList;
import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getSurveyQuestion (int surId); // 설문 질문 조회

    default QuestionDTO dtoToEntity(Question question, List<QuestionOption> questionOptionList) {
        QuestionDTO questionDTO = QuestionDTO.builder()
                .queId(question.getQueId())
                .surId(question.getSurvey().getSurId())
                .qType(question.getQType())
                .content(question.getContent())
                .optionList(new ArrayList<>())
                .build();
        questionOptionList.forEach(questionOption -> {
            questionDTO.addOptionList(questionOption);
        });
        return questionDTO;
    }
}
