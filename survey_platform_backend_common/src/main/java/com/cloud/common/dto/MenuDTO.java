package com.cloud.common.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuDTO {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private String menuIcon;
    private List<MenuDTO> menuList;

    public void addMenuList(MenuDTO menuDTO) {
        menuList.add(menuDTO);
    }
}
