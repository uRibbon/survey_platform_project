package com.cloud.auth.dto;

import com.cloud.auth.entity.DelYn;
import com.cloud.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // 개설자 정보
    private String regId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;

    private String modId;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDt;

    private List<User> prtcpList;

    private DelYn delYn;

    public void addPrtcpList(User user) {
        prtcpList.add(user);
    }
}