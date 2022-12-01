package com.cloud.survey.service;

import com.cloud.survey.entity.SurveyVulgarism;
import com.cloud.survey.repository.VulgarismRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class SurveyVulgarismServiceImpl implements SurveyVulgarismService {

    @Autowired
    VulgarismRepository vulgarismRepository;

    @Override
    @Transient
    public void InsertVulgarism(int surID, boolean InfoYn, boolean QuestionYn){
        SurveyVulgarism vulgarism = SurveyVulgarism.builder()
                .surId(surID)
                .infoYn(InfoYn)
                .questionYn(QuestionYn)
                .build();
        vulgarismRepository.save(vulgarism);
    }
}
