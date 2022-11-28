package com.cloud.common.controller;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.Menu;
import com.cloud.common.service.MenuService;
import com.cloud.common.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="v1/common")
@RequiredArgsConstructor
public class CommonServiceController {
    private final MenuService menuService;
    private final KafkaProducer producer;

    @GetMapping("/test")
    public String test() {
        return "Common서버로부터 응답.";
    }


    @GetMapping("/menu")
    public List<MenuDTO> getUserMenuDTO(Principal principal) {
        System.out.println("principal = " + principal);
        if (principal != null) {
            JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
            Map<String,Object> resource_access = (Map<String,Object>) token.getTokenAttributes().get("resource_access");
            Map<String, Object> team_cloud_client = (Map<String, Object>) resource_access.get("team_cloud_client");
            ArrayList<String> roles = (ArrayList) team_cloud_client.get("roles");
            if (roles.get(0).equals("USER")) {
                return menuService.getUserMenuDTOList();
            } else if (roles.get(0).equals("ADMIN")) {
                return menuService.getAdminMenuDTOList();
            }
        }
        return menuService.getAllMenuDTOList();
    }

    @PostMapping("/kafkaConnTest")
    public String sendMessage(@RequestParam("message") String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}

