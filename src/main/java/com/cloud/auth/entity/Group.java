package com.cloud.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(catalog = "user_db", name = "group")
public class Group {
    @Id
    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "group_name", nullable = false, length = 30)
    private String groupName;

    @Column(name = "group_description", nullable = false, length = 100)
    private String groupDescription;

    @Column(name = "group_cnt", nullable = false)
    private Integer groupCnt;

    @ManyToOne
    @JoinColumn(name = "reg_id", nullable = false)
    private User user;

    @Column(name = "reg_dt", nullable = false, length = 20)
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Column(name = "del_yn")
    @Enumerated(EnumType.STRING)
    private DelYn delYn;
}
