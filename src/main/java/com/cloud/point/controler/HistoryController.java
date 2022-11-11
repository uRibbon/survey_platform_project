package com.cloud.point.controler;

import com.cloud.point.entity.PointHistory;
import com.cloud.point.repository.PointHistoryRepository;
import com.cloud.point.service.PointHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/point")
@Slf4j
@RequiredArgsConstructor
public class HistoryController {
    // repository가 아닌 service 선언하기
    private final PointHistoryService pointHistoryService;

//    @Autowired
//    PointHistoryRepository pointHistoryRepository;
//
//    @PostMapping("/list")
//    public PointHistory pointHistory(@RequestBody PointHistory pointHistory) {
//        log.info("id = " + pointHistory.getPointHisNo());
//        PointHistory pointHistory1 = pointHistoryRepository.findById(pointHistory.getPointHisNo()).orElse(null);
//        return pointHistory1;
//    }

    // 전체 리스트 출력 api
    @GetMapping("/list")
    public List<PointHistory> getAllHistory() {
        List<PointHistory> allPointHistoryList = pointHistoryService.getAllPointHistoryList();
        return allPointHistoryList;
    }

    // 히스토리 아이디에 따른 히스토리 출력 api
    @GetMapping("/list/{pointHisNo}")
    public PointHistory getOneHistory(@PathVariable Integer pointHisNo) {
        PointHistory pointHistory = pointHistoryService.getOnePointHistory(pointHisNo);
        return pointHistory;
    }
}
