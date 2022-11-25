package com.cloud.auth.service;

import com.cloud.auth.dto.GroupDetailDTO;
import com.cloud.auth.entity.Group;
import com.cloud.auth.entity.GroupDetail;
import com.cloud.auth.entity.User;
import com.cloud.auth.repository.UserGroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface GroupDetailService {

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
}
