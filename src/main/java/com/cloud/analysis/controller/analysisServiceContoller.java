package com.cloud.analysis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/analysis")
public class analysisServiceContoller {

    @GetMapping("/test")
    public String test() {
        return "분석 서버로부터 응답";
    }
}


