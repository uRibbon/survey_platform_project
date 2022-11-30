package com.cloud.auth.service;

import com.cloud.auth.entity.User;
import com.cloud.auth.entity.UserGroup;
import com.cloud.auth.repository.GroupRepository;
import com.cloud.auth.repository.UserGroupRepository;
import com.cloud.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupServiceImpl implements UserGroupService{

    private final UserGroupRepository userGroupRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;


    @Override
    public void participateGroup(String userId, Integer groupId) {
        UserGroup userGroup = UserGroup.builder()
                        .group(groupRepository.findById(groupId).orElse(null))
                        .user(userRepository.findByUserId(userId))
                        .build();
        userGroupRepository.save(userGroup);

        groupRepository.updateGroupCnt(groupId);
    }

    @Override
    public boolean isParticipated(String userId, Integer groupId) {
        List<User> userList = userGroupRepository.userList(groupId);
        if(userList.contains(userId)) {
            return true;
        }
        else {
            return false;
        }
    }
}
