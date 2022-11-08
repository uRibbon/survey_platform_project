package com.cloud.point.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/point")
public class pointController {

    @GetMapping("/test")
    public String test() {
        return "return";
    }
    @GetMapping("/list")
    public String getList() {
        return "point 내역에 대한 조회로부터 응답";
    }

    /*@GetMapping("/total")
    public Point getTotal() {
        return "";
    }*/
}
