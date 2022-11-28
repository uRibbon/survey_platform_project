package com.cloud.point.controller;


import com.cloud.point.dto.UserPointDTO;
import com.cloud.point.service.UserPointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/point")
@Slf4j
public class pointController {
    @Autowired
    UserPointService userPointService;

    @PostMapping("/search")
    public UserPointDTO userPoint(@RequestParam(value = "userId") String userId) {
        UserPointDTO oneUserPoint = userPointService.getOneUserPoint(userId);
        return oneUserPoint;
    }
}
