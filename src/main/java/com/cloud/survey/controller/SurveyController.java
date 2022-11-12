package com.cloud.survey.controller;

import com.cloud.survey.dto.SurveyDTO;
import com.cloud.survey.entity.IsYn;
import com.cloud.survey.entity.SurveyStatus;
import com.cloud.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<SurveyDTO>> getSurveyList(@RequestParam (value = "status") SurveyStatus status,
                                                         @RequestParam (value = "is_private") IsYn isPrivateYn) {
        return new ResponseEntity<>(surveyService.getSurveyList(status, isPrivateYn), HttpStatus.CREATED);
    }

}
