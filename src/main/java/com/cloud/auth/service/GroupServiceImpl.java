package com.cloud.auth.service;

import com.cloud.auth.dto.GroupDTO;
import com.cloud.auth.dto.GroupListDTO;
import com.cloud.auth.dto.PageRequestDTO;
import com.cloud.auth.dto.PageResultDTO;
import com.cloud.auth.entity.Group;
import com.cloud.auth.entity.User;
import com.cloud.auth.entity.UserGroup;
import com.cloud.auth.repository.GroupRepository;
import com.cloud.auth.repository.UserGroupRepository;
import com.cloud.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final UserGroupRepository userGroupRepository;

    private final UserRepository userRepository;

    // 그룹 리스트 조회
    @Override
    public PageResultDTO<GroupDTO, Group> getGroupList(String userId, PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("groupId").descending());
        Page<Group> groupListPage = groupRepository.findExistGroup(pageable);
        Function<Group, GroupDTO> fn = ((group)->{
            List<User> prtcpList = userGroupRepository.userList(group.getGroupId());
            return entityToDTO(group, prtcpList);
        });
        return new PageResultDTO<>(groupListPage, fn);
    }

    // 그룹 삭제
    @Override
    public Integer deleteGroup(Integer groupId) {
        System.out.println("groupId = " + userGroupRepository.userList(groupId));
        // 값이 없으면 delete, return 1
        if(userGroupRepository.userList(groupId).isEmpty()) {
            groupRepository.updateGroupDelY(groupId);
            return 1;
        }

        // 값이 있으면 return 0
        else {
            return 0;
        }
    }

    // 그룹 생성
    @Override
    public void insertGroup(GroupListDTO groupListDTO) {
        User user = userRepository.findByUserId(groupListDTO.getRegId());
        Group group = dtoToEntity(groupListDTO, user);
        groupRepository.save(group);
    }


}
