package com.cloud.auth.service;
import com.cloud.auth.dto.GroupListDTO;
import com.cloud.auth.dto.PageRequestDTO;
import com.cloud.auth.dto.PageResultDTO;
import com.cloud.auth.entity.Group;

public interface GroupService {
//    List<Group> getGroupList();
    PageResultDTO<GroupListDTO, Group> getGroupList(String userId, PageRequestDTO requestDTO);

    default Group dtoToEntity(GroupListDTO dto) {
        Group group = Group.builder()
                .groupId(dto.getGroupId())
                .groupName(dto.getGroupName())
                .groupDescription(dto.getGroupDescription())
                .groupCnt(dto.getGroupCnt())
                .user(dto.getUser())
                .regDt(dto.getRegDt())
                .modId(dto.getModId())
                .modDt(dto.getModDt())
                .delYn(dto.getDelYn())
                .build();
        return group;
    }

    default GroupListDTO entityToDTO(Group group) {
        GroupListDTO dto = GroupListDTO.builder()
                .groupId(group.getGroupId())
                .groupName(group.getGroupName())
                .groupDescription(group.getGroupDescription())
                .groupCnt(group.getGroupCnt())
                .user(group.getUser())
                .regDt(group.getRegDt())
                .modId(group.getModId())
                .modDt(group.getModDt())
                .delYn(group.getDelYn())
                .build();
        return dto;
    }
}
