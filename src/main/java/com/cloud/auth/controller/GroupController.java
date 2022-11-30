package com.cloud.auth.controller;

가import com.cloud.auth.dto.*;
import com.cloud.auth.entity.Group;
import com.cloud.auth.service.GroupService;
import com.cloud.auth.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value="v1/group")
@Slf4j
@RequiredArgsConstructor
public class GroupController {
    @Autowired
    private final GroupService groupService;

    @Autowired
    private final UserGroupService userGroupService;

    @PostMapping("/list")
    public ResponseEntity<PageResultDTO<GroupDTO, Group>> getGroupList(Principal principal, PageRequestDTO pageRequestDTO) {
        System.out.println("principal = " + principal);
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String userId = token.getTokenAttributes().get("preferred_username").toString();

        PageResultDTO<GroupDTO, Group> groupList = groupService.getGroupList(userId, pageRequestDTO);
        //System.out.println(token.getTokenAttributes());
        return new ResponseEntity<>(groupList, HttpStatus.OK);
    }

    // 그룹 삭제
    @PostMapping("/delete")
    public ResponseEntity<String> delGroup(@RequestParam(value = "groupId") Integer groupId) {
        System.out.println("groupId = " + groupId);
        Integer deleteGroup = groupService.deleteGroup(groupId);
        if(deleteGroup == 1) {
            return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("삭제 불가", HttpStatus.BAD_REQUEST);
        }
    }

    // 그룹 생성
    @PostMapping("/reg")
    public ResponseEntity<String> regGroup(@RequestBody GroupListDTO groupListDTO) {
        groupService.insertGroup(groupListDTO);
        return new ResponseEntity<>("성공했습니다", HttpStatus.OK);
    }

    // 그룹 참여
    @PostMapping("/participate")
    public void participateGroup(
            @RequestParam(value = "groupId") Integer groupId,
            @RequestParam(value = "userId") String userId) {
        userGroupService.participateGroup(userId, groupId);
    }

    @PostMapping("/isParticipated")
    public boolean isParticipated(
            @RequestParam(value = "groupId") Integer groupId,
            @RequestParam(value = "userId") String userId) {
        return userGroupService.isParticipated(userId, groupId);
    }
}

