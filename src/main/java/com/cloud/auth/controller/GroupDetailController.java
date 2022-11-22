package com.cloud.auth.controller;


import com.cloud.auth.entity.GroupDetail;
import com.cloud.auth.service.GroupDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/group")
@Slf4j
@RequiredArgsConstructor
public class GroupDetailController {

    private final GroupDetailService groupDetailService;

    @PostMapping("/detail")
    public List<GroupDetail> getAllDetailList() {
        List<GroupDetail> allDetailList = groupDetailService.getAllDetailList();
        return allDetailList;
    }
}
