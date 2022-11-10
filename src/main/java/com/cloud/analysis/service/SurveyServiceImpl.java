package com.cloud.analysis.service;

import com.cloud.analysis.entity.Survey;
import com.cloud.analysis.entity.User;
import com.cloud.analysis.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{
    @Autowired
    private final SurveyRepository surveyRepository;


    public LocalDateTime find_reg_dt(Integer id) {
        LocalDateTime answer;
        List<Survey> surveyList = surveyRepository.findAll();

        surveyList.forEach(survey -> {
                    System.out.println("user = " + survey.toString());

        }
        );
        return null;
    }

}
