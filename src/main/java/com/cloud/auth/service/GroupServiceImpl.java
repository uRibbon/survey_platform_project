package com.cloud.auth.service;

import com.cloud.auth.dto.GroupListDTO;
import com.cloud.auth.dto.PageRequestDTO;
import com.cloud.auth.dto.PageResultDTO;
import com.cloud.auth.entity.Group;
import com.cloud.auth.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public PageResultDTO<GroupListDTO, Group> getGroupList(String userId, PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("regDt").descending());
        Page<Group> groupListPage = groupRepository.findExistGroup(pageable);
        Function<Group, GroupListDTO> fn = (groupList -> entityToDTO(groupList));
        return new PageResultDTO<>(groupListPage, fn);
    }
}
