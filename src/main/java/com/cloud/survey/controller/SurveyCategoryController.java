package com.cloud.survey.controller;

import com.cloud.survey.dto.PageRequestDTO;
import com.cloud.survey.dto.PageResultDTO;
import com.cloud.survey.dto.SurveyCategoryDTO;
import com.cloud.survey.entity.SurveyCategory;
import com.cloud.survey.repository.SurveyCategoryRepository;
import com.cloud.survey.service.SurveyCategoryService;
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
    private final SurveyCategoryService surveyCategoryService;

    // pagination 미처리
    @GetMapping("/list")
    public ResponseEntity<PageResultDTO<SurveyCategoryDTO, SurveyCategory>> getCategoryList(PageRequestDTO pageRequestDTO) {
        PageResultDTO<SurveyCategoryDTO, SurveyCategory> categoryList = surveyCategoryService.getCategoryList(pageRequestDTO);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/reg")
    public ResponseEntity<String> registerCategory(SurveyCategory surveyCategory) {
        surveyCategoryService.insertCategory(surveyCategory);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/del/{surCatId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer surCatId) {
        surveyCategoryService.deleteCategory(surCatId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
