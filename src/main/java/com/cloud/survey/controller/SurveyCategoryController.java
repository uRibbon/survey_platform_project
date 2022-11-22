package com.cloud.survey.controller;

import com.cloud.survey.dto.PageRequestDTO;
import com.cloud.survey.dto.PageResultDTO;
import com.cloud.survey.dto.survey.SurveyCategoryDTO;
import com.cloud.survey.entity.SurveyCategory;
import com.cloud.survey.service.SurveyCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value="v1/survey/category")
@RequiredArgsConstructor
public class SurveyCategoryController {
    private final SurveyCategoryService surveyCategoryService;

    @GetMapping("/list")
    public ResponseEntity<PageResultDTO<SurveyCategoryDTO, SurveyCategory>> getCategoryList(PageRequestDTO pageRequestDTO) {
        PageResultDTO<SurveyCategoryDTO, SurveyCategory> categoryList = surveyCategoryService.getCategoryList(pageRequestDTO);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/reg")
    public ResponseEntity<String> registerCategory(SurveyCategoryDTO surveyCategoryDTO) {
        surveyCategoryService.insertCategory(surveyCategoryDTO);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> deleteCategory(@RequestBody(required = false) List<Integer> surCatIdList) {
        System.out.println("surCatIdList = " + surCatIdList);
        surCatIdList.forEach(surCatId -> {
            surveyCategoryService.deleteCategory(surCatId);
        });
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
