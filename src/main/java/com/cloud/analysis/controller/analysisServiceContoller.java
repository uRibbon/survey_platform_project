package com.cloud.analysis.controller;

import com.cloud.analysis.entity.Analysis;
import com.cloud.analysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="v1/survey")
public class analysisServiceContoller {

    @Autowired
    private AnalysisService analysisService;

    @GetMapping("/test")
    public String test() {
        return "분석 서버로부터 응답";
    }

//    @GetMapping("/analysis/{surId}")
//    public List<Object> overall(@PathVariable Integer surId) {
//        List<Object> allAnswerList = analysisService.getUserAnswerList(surId);
//        return allAnswerList;
//    }
}
