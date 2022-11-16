package com.cloud.auth.controller;

import com.cloud.auth.entity.Group;
import com.cloud.auth.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/user")
@Slf4j
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;


    @GetMapping("/groupList")
    public List<Group> getGroupList() {
        List<Group> GroupList = groupService.getGroupList();
        return GroupList;
    }
}
