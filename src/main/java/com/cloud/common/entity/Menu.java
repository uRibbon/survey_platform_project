package com.cloud.common.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(catalog = "common_db")
public class Menu {
    @Id
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "pmenu_id", nullable = false)
    private Integer pmenuId;

    @Column(name="menu_name", nullable = false, length = 20)
    private String menuName;

    @Column(name = "use_yn", nullable = false)
    private Boolean useYn;

    @Column(name = "menu_url", length = 20)
    private String menuUrl;

    @Column(name = "menu_icon", length = 20)
    private String menuIcon;

    @Column(name = "sort_idx")
    private Integer sortIdx;

    @Column(name = "reg_id", nullable = false, length = 20)
    private String regId;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_id", length = 20)
    private String modId;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;
}
