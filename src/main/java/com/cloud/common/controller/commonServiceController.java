package com.cloud.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/common")
public class commonServiceController {
    @GetMapping("/test")
    public String test() {
        return "Common서버로부터 응답.";
    }
}

