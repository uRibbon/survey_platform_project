package com.cloud.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "group_file")
public class GroupFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("그룹 파일 아이디")
    @Column(name = "group_file_id", nullable = false)
    private Integer groupFileId;

    @Comment("그룹 아이디")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Comment("그룹 파일 이름")
    @Column(name = "org_name", nullable = false, length = 100)
    private String orgName;

    @Comment("그룹 파일 이름")
    @Column(name = "sys_name", nullable = false, length = 50)
    private String sysName;

    @Comment("그룹 파일 사이즈")
    @Column(name = "size", nullable = false, length = 20)
    private Integer size;

    @Comment("그룹 파일 삭제 여부")
    @ColumnDefault("false")
    @Column(name = "del_yn", nullable = false)
    private Boolean delYn;

    @Comment("그룹 파일 생성자")
    @Column(name = "reg_id", nullable = false, length = 20)
    private String regId;

    @Comment("그룹 파일 생성일자")
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;
}
