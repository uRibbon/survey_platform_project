package com.cloud.auth.service;

import com.cloud.auth.dto.GroupDetailDTO;
import com.cloud.auth.entity.GroupDetail;
import com.cloud.auth.entity.User;
import com.cloud.auth.repository.GroupDetailRepository;
import com.cloud.auth.repository.UserGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GroupDetailServiceImpl implements GroupDetailService{

    private final GroupDetailRepository groupDetailRepository;
    private final UserGroupRepository userGroupRepository;

    public GroupDetailDTO getOneGroupDetail(Integer groupId) {
        GroupDetail groupDetail = groupDetailRepository.findByGroupId(groupId);
        List<User> userList = userGroupRepository.userList(groupId);
        GroupDetailDTO groupDetailDTO = entityToDTO(groupDetail, userList);
        return groupDetailDTO;
    }
}
