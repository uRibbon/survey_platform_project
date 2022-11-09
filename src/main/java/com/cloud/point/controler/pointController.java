package com.cloud.point.controler;


import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
@RequestMapping(value="v1/point")
@Slf4j
public class pointController {
    @GetMapping("/test/{id}")
    public String test(@PathVariable Integer id, Model model) {
        log.info("id = " + id);
        Optional<UserPoint> byId = UserPointRepository.findById(1);
        if (byId.isPresent()) {
            UserPoint userPoint = byId.get();
        }
        model.addAttribute("userPoint", userPointEntity);
        return "gg";
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
