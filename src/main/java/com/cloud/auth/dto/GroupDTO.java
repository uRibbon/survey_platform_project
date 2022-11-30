package com.cloud.auth.dto;

import com.cloud.auth.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupDTO {
    private Integer groupId;
    private String groupName;
    private String groupDescription;
    private Integer groupCnt;
    private String userId;
    private String userName;
    private String userMailAddr;
    private List<User> prtcpList;

    public void addPrtcpList(User user) {
        prtcpList.add(user);
    }
}