package com.cloud.common.controller;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.Menu;
import com.cloud.common.service.MenuService;
import com.cloud.common.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/common")
@RequiredArgsConstructor
public class commonServiceController {
    private final MenuService menuService;
    private final KafkaProducer producer;

    @GetMapping("/test")
    public String test() {
        return "Common서버로부터 응답.";
    }

    @GetMapping("/menu")
    public List<MenuDTO> getAllMenuDTO(Model model) {
        List<MenuDTO> allMenuDTOList = menuService.getAllMenuDTOList();
        model.addAttribute("allMenuDTOList", allMenuDTOList);
        return allMenuDTOList;
    }

    @PostMapping("/kafkaConnTest")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}

