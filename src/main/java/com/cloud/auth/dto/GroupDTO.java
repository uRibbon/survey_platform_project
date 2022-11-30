package com.cloud.auth.dto;

import com.cloud.auth.entity.DelYn;
import com.cloud.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class GroupDTO {

    private Integer groupId;

    private String groupName;

    private Integer groupCode;

    private String groupDescription;

    private Integer groupCnt;

    private String regId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;

    private String modId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDt;

    private List<User> prtcpList;

    private DelYn delYn;

    // 아래 : 그룹 참여자 정보
    private String userId;

    private String userName;

    private String userMailAddr;

    public void addPrtcpList(User user) {
        prtcpList.add(user);
    }
}