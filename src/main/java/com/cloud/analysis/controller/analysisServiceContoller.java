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

//    @RequestMapping(value = "/analysis/{analysisId}", method = RequestMethod.POST)
//    public List<Object> analysis_list(@PathVariable Integer analysisId) {
//        List<Object> allAnalysisList = analysisService.getAnalysisList(analysisId);
//        return allAnalysisList;
//    }

    @RequestMapping(value = "/analysis", method = RequestMethod.POST)
        public ResponseEntity<Map<String, Object>> getSurveyDetail(@RequestParam (value = "analysis_Id") int analysisId) {

        Map<String, Object> map = new HashMap<>();
        map.put("analysis_Id", analysisService.getAnalysisList(analysisId));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
