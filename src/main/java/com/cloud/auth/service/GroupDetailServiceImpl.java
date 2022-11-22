package com.cloud.auth.service;

import com.cloud.auth.entity.Group;
import com.cloud.auth.entity.GroupDetail;
import com.cloud.auth.repository.GroupDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GroupDetailServiceImpl implements GroupDetailService{

    private final GroupDetailRepository groupDetailRepository;

    @Override
    public List<GroupDetail> getAllDetailList() {
            List<GroupDetail> groupDetailList = groupDetailRepository.findAll();
            return groupDetailList;
    }
}
