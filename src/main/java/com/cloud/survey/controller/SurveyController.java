package com.cloud.survey.controller;

import com.cloud.survey.dto.survey.SurveyDTO;
import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.Survey;
import com.cloud.survey.entity.SurveyStatus;
import com.cloud.survey.service.QuestionService;
import com.cloud.survey.service.SurveyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="v1/survey")
@Log4j2
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private QuestionService questionService;

    // 설문 리스트 조회
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<SurveyDTO>> getSurveyList(@RequestParam (value = "status") SurveyStatus status,
                                                         @RequestParam (value = "is_private") IsYn isPrivateYn) {
        return new ResponseEntity<>(surveyService.getSurveyList(status, isPrivateYn), HttpStatus.OK);
    }

    // 설문 상세정보, 질문 조회
    @Transactional
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getSurveyDetail(@RequestParam (value = "sur_id") int surId) {

        Map<String, Object> map = new HashMap<>();
        map.put("info", surveyService.getSurveyDetail(surId));
        map.put("question_list", questionService.getSurveyQuestion(surId));

        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    // 카테고리별 인기 설문조사 조회
    @GetMapping("/best")
    public ResponseEntity<List<Survey>> getBestSurveyList() {
        List<Survey> bestSurveyList = surveyService.getBestSurvey();
        return new ResponseEntity<>(bestSurveyList, HttpStatus.OK);
    }

}
