package com.cloud.auth.controller;


import com.cloud.auth.dto.GroupDetailDTO;
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

    @GetMapping("/detail/{groupId}")
    public GroupDetail oneGroupDetail(@PathVariable Integer groupId) {
        GroupDetailDTO groupDetailDTO = groupDetailService.dtoToEntity();
        return groupDetailDTO;
    }
}
