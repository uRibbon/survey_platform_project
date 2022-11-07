package com.cloud.common.service;

import com.cloud.common.dto.MenuDTO;
import com.cloud.common.entity.Menu;
import com.cloud.common.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    @Autowired
    private final MenuRepository menuRepository;

    @Override
    public List<MenuDTO> getAllMenuDTOList() {
        List<MenuDTO> menuDTOList = new ArrayList<>();
        List<Menu> largeCategoryList = menuRepository.findLargeCategoryList();
        largeCategoryList.forEach(largeCategory -> {
            MenuDTO largeCategoryDTO = entityToDTO(largeCategory);
            List<Menu> middleCategoryList = menuRepository.findMiddleCategoryList(largeCategory.getMenuId());
            middleCategoryList.forEach(middleCategory -> {
                MenuDTO middleCategoryDTO = entityToDTO(middleCategory);
                largeCategoryDTO.addMenuDTOList(middleCategoryDTO);
                List<Menu> smallCategoryList = menuRepository.findSmallCategoryList(middleCategory.getMenuId());
                smallCategoryList.forEach(smallCategory -> {
                    MenuDTO smallCategoryDTO = entityToDTO(smallCategory);
                   middleCategoryDTO.addMenuDTOList(smallCategoryDTO);
                });
            });
            menuDTOList.add(largeCategoryDTO);
        });
        return menuDTOList;
    }

    @Override
    public List<Menu> getAllMenuList() {
        List<Menu> menuList = new ArrayList<>();
        List<Menu> largeCategoryList = menuRepository.findLargeCategoryList();
        largeCategoryList.forEach(largeCategory -> {
            largeCategory.setMenuList(new ArrayList<>());
            List<Menu> middleCategoryList = menuRepository.findMiddleCategoryList(largeCategory.getMenuId());
            middleCategoryList.forEach(middleCategory -> {
                largeCategory.addMenuList(middleCategory);
                middleCategory.setMenuList(new ArrayList<>());
                List<Menu> smallCategoryList = menuRepository.findSmallCategoryList(middleCategory.getMenuId());
                smallCategoryList.forEach(smallCategory -> {
                    middleCategory.addMenuList(smallCategory);
                });
            });
            menuList.add(largeCategory);
        });
        return menuList;
    }
}
