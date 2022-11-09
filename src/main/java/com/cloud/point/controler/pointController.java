package com.cloud.point.controler;


import com.cloud.point.entity.UserPoint;
import com.cloud.point.repository.UserPointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserPointRepository userPointRepository;

    @GetMapping("/test/{id}")
    public UserPoint test(@PathVariable Integer id, Model model) {
        log.info("id = " + id);
        UserPoint userPoint = userPointRepository.findById(id).orElse(null);
        model.addAttribute("userPoint", userPoint);
        return userPoint;
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
