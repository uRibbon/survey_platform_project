package com.cloud.point.controler;


import com.cloud.point.entity.UserPoint;
import com.cloud.point.entity.PointHistory;
import com.cloud.point.repository.PointHistoryRepository;
import com.cloud.point.repository.UserPointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
@RequestMapping(value="v1/point")
@Slf4j
public class pointController {
    @Autowired
    UserPointRepository userPointRepository;

    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @GetMapping("/total/{id}")
    public UserPoint userPoint(@PathVariable Integer id, Model model) {
        log.info("id = " + id);
        UserPoint userPoint = userPointRepository.findById(id).orElse(null);
        model.addAttribute("userPoint", userPoint);
        return userPoint;
    }

    @GetMapping("/list/{pointHisNo}")
    public PointHistory pointHistory(@PathVariable Integer pointHisNo, Model model) {
        //log.info("id = " + id);
        PointHistory pointHistory = pointHistoryRepository.findById(pointHisNo).orElse(null);
        model.addAttribute("pointHistory", pointHistory);
        return pointHistory;
    }
}
