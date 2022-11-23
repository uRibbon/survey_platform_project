package com.cloud.auth.service;

import com.cloud.auth.dto.GroupDetailDTO;
import com.cloud.auth.entity.GroupDetail;
import com.cloud.auth.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface GroupDetailService {
    default GroupDetailDTO dtoToEntity(GroupDetail groupDetail, List<User> userList) {
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
}
