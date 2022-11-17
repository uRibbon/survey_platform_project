package com.cloud.auth.controller;

import com.cloud.auth.dto.GroupListDTO;
import com.cloud.auth.dto.PageRequestDTO;
import com.cloud.auth.dto.PageResultDTO;
import com.cloud.auth.entity.Group;
import com.cloud.auth.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/user")
@Slf4j
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/groupList")
    public ResponseEntity<PageResultDTO<GroupListDTO, Group>> getGroupList(PageRequestDTO pageRequestDTO) {
        PageResultDTO<GroupListDTO, Group> groupList = groupService.getGroupList(pageRequestDTO);
        return new ResponseEntity<>(groupList, HttpStatus.OK);
    }


}
