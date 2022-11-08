package com.cloud.common.controller;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.Menu;
import com.cloud.common.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="v1/common")
public class commonServiceController {
    @Autowired
    private MenuService menuService;

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
}

