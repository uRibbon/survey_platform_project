package com.cloud.point.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/point")
public class pointListController {
    @GetMapping("/list")
    public String test() {
        return "point 내역에 대한 조회로부터 응답";
    }
}
