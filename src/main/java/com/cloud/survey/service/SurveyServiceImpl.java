package com.cloud.survey.service;

import com.cloud.survey.dto.SurveyDTO;
import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;
import com.cloud.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{
    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final ModelMapper mapper;

    @Override
    public List<SurveyDTO> getSurveyList(SurveyStatus status, IsYn isPrivateYn){

        List<SurveyDTO> surveyDtoList = new ArrayList<>();
        List<Survey> surveyList = surveyRepository.findByStatusAndIsPrivateYn(status, isPrivateYn);

        surveyList.forEach(survey -> {
            SurveyDTO surveydto = mapper.map(survey, SurveyDTO.class);
            surveyDtoList.add(surveydto);
        });
        return surveyDtoList;
    }


}
