package com.cloud.point.controller;


import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/point")
@Slf4j
public class pointController {
    @Autowired
    UserPointRepository userPointRepository;

    @PostMapping("/total")
    public UserPoint userPoint(@RequestBody UserPoint userPoint) {
        log.info("id = " + userPoint.getId());
        UserPoint userPoint1 = userPointRepository.findById(userPoint.getId()).orElse(null);
        return userPoint1;
    }
}
