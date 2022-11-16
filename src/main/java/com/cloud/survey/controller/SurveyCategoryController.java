package com.cloud.survey.controller;

import com.cloud.survey.entity.SurveyCategory;
import com.cloud.survey.repository.SurveyCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value="v1/survey/category")
@RequiredArgsConstructor
public class SurveyCategoryController {
    private final SurveyCategoryRepository surveyCategoryRepository;

    // pagination 미처리
    @GetMapping("/read")
    public ResponseEntity<List<SurveyCategory>> getCategoryList() {
        List<SurveyCategory> surveyCategoryList = surveyCategoryRepository.findAll();
        return new ResponseEntity<>(surveyCategoryList, HttpStatus.OK);
    }

    @PostMapping("/reg")
    public ResponseEntity<String> registerCategory(SurveyCategory surveyCategory) {
        surveyCategoryRepository.save(surveyCategory);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/del/{surCatId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer surCatId) {
        surveyCategoryRepository.deleteById(surCatId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
