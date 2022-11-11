package com.cloud.point.controler;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.repository.PointHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/point")
@Slf4j
public class HistoryController {

    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @PostMapping("/list")
    public PointHistory pointHistory(@RequestBody PointHistory pointHistory) {
        log.info("id = " + pointHistory.getPointHisNo());
        PointHistory pointHistory1 = pointHistoryRepository.findById(pointHistory.getPointHisNo()).orElse(null);
        return pointHistory1;
    }
}
