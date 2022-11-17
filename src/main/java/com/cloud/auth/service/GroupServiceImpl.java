package com.cloud.auth.service;

import com.cloud.auth.entity.Group;
import com.cloud.auth.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public List<Group> getGroupList() {
        List<Group> GroupList = groupRepository.findExistGroup();
        return GroupList;
    }
}
