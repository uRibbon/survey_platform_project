package com.cloud.auth.controller;

import com.cloud.auth.dto.GroupListDTO;
import com.cloud.auth.dto.PageRequestDTO;
import com.cloud.auth.dto.PageResultDTO;
import com.cloud.auth.entity.Group;
import com.cloud.auth.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value="v1/group")
@Slf4j
public class GroupController {
    @Autowired
    private  GroupService groupService;

    @PostMapping("/groupList")
    public ResponseEntity<PageResultDTO<GroupListDTO, Group>> getGroupList(Principal principal, PageRequestDTO pageRequestDTO) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String userId = token.getTokenAttributes().get("preferred_username").toString();

        PageResultDTO<GroupListDTO, Group> groupList = groupService.getGroupList(userId, pageRequestDTO);
        return new ResponseEntity<>(groupList, HttpStatus.OK);
    }


}
