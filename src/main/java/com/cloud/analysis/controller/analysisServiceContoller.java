package com.cloud.analysis.controller;

import com.cloud.analysis.entity.Analysis;
import com.cloud.analysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="v1/survey")
public class analysisServiceContoller {
    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/test")
    public String test() {
        return "분석 서버로부터 응답";
    }

    @RequestMapping(value = "/analysis", method = RequestMethod.POST)
    public List<Object> getAnalysisList(@RequestParam (value = "analysis_Id") int analysisId) {
        List<Object> allAnalysisList = analysisService.getAnalysisList(analysisId);
        return allAnalysisList;
    }
}
