package com.cloud.point.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/point")
public class pointTotalController {
    @GetMapping("/total")
    public String test() {
        return "point 조회 서버로부터 응답";
    }
}
