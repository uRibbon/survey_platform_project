package com.cloud.common.service;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public interface MenuService {
    List<MenuDTO> getAllMenuDTOList();

    default MenuDTO entityToDTO(Menu menu) {
        MenuDTO dto = MenuDTO.builder()
                .menuId(menu.getMenuId())
                .menuName(menu.getMenuName())
                .menuUrl(menu.getMenuUrl())
                .menuIcon(menu.getMenuIcon())
                .menuList(new ArrayList<>())
                .build();
        return dto;
    }
}
