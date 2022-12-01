package com.cloud.auth.service;
import com.cloud.auth.dto.GroupDTO;
import com.cloud.auth.dto.GroupDetailDTO;
import com.cloud.auth.dto.PageRequestDTO;
import com.cloud.auth.dto.PageResultDTO;
import com.cloud.auth.entity.Group;
import com.cloud.auth.entity.GroupDetail;
import com.cloud.auth.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface GroupService {

    GroupDetailDTO getOneGroupDetail(Integer groupId);
    default GroupDetailDTO entityToDTO(GroupDetail groupDetail, List<User> userList) {
        GroupDetailDTO groupDetailDTO = GroupDetailDTO.builder()
                .groupId(groupDetail.getGroupId())
                .groupName(groupDetail.getGroupName())
                .groupDescription(groupDetail.getGroupDescription())
                .groupCnt(groupDetail.getGroupCnt())
                .userList(new ArrayList<>())
                .regDt(groupDetail.getRegDt())
                .modId(groupDetail.getModId())
                .modDt(groupDetail.getModDt())
                .build();
        userList.forEach(user -> {
            groupDetailDTO.addUserList(user);
        });

        return groupDetailDTO;
    }

    PageResultDTO<GroupDTO, Group> getGroupList(String userId, PageRequestDTO requestDTO);

    // 그룹 삭제
    Integer deleteGroup(Integer groupId);

    // 그룹 생성
    void insertGroup(GroupDTO groupDTO);


    default Group dtoToEntity(GroupDTO dto, User user) {
        Group group = Group.builder()
                .groupId(dto.getGroupId())
                .groupName(dto.getGroupName())
                .groupCode(dto.getGroupCode())
                .groupDescription(dto.getGroupDescription())
                .groupCnt(dto.getGroupCnt())
                .user(user)
                .regDt(dto.getRegDt())
                .modId(dto.getModId())
                .modDt(dto.getModDt())
                .delYn(dto.getDelYn())
                .build();
        return group;
    }

    default GroupDTO entityToDTO(Group group, List<User> prtcpList) {
        GroupDTO dto = GroupDTO.builder()
                .groupId(group.getGroupId())
                .groupName(group.getGroupName())
                .groupCode(group.getGroupCode())
                .groupDescription(group.getGroupDescription())
                .groupCnt(group.getGroupCnt())
                .regId(group.getUser().getUserId())
                .prtcpList(new ArrayList<>())
                .regDt(group.getRegDt())
                .delYn(group.getDelYn())
                .build();
        prtcpList.forEach((user) -> {
            dto.addPrtcpList(user);
        });
        return dto;
    }
}
