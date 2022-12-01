//package com.cloud.common.repository;
//
//import com.cloud.common.entity.Menu;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class MenuRepositoryTest {
//    @Autowired
//    MenuRepository menuRepository;
//
//    @Test
//    void read() {
//        List<Menu> menuList = menuRepository.findAll();
//        menuList.forEach(menu -> {
//            System.out.println("menu.toString() = " + menu.toString());
//        });
//    }
//
//    @Test
//    void getLargeCategory() {
//        List<Menu> largeCategoryList = menuRepository.findLargeCategoryList();
//        largeCategoryList.forEach(largeCategory -> {
//            System.out.println("largeCategory.toString() = " + largeCategory.toString());
//        });
//    }
//
//    @Test
//    void getMiddleCategory() {
//        List<Menu> largeCategoryList = menuRepository.findLargeCategoryList();
//        largeCategoryList.forEach(largeCategory -> {
//            List<Menu> middleCategoryList = menuRepository.findMiddleCategoryList(largeCategory.getMenuId());
//            middleCategoryList.forEach(middleCategory -> {
//                System.out.println("middleCategory.toString() = " + middleCategory.toString());
//            });
//        });
//    }
//
//    @Test
//    void getSmallCategory() {
//        List<Menu> largeCategoryList = menuRepository.findLargeCategoryList();
//        largeCategoryList.forEach(largeCategory -> {
//            List<Menu> middleCategoryList = menuRepository.findMiddleCategoryList(largeCategory.getMenuId());
//            middleCategoryList.forEach(middleCategory -> {
//                List<Menu> smallCategoryList = menuRepository.findAllSmallCategoryList(middleCategory.getMenuId());
//                smallCategoryList.forEach(smallCategory -> {
//                    System.out.println("smallCategory.toString() = " + smallCategory.toString());
//                });
//            });
//        });
//    }
//
//    @Test
//    void getAllCategory() {
//        List<Menu> largeCategoryList = menuRepository.findLargeCategoryList();
//        largeCategoryList.forEach(largeCategory -> {
//            System.out.println("largeCategory = " + largeCategory);
//            List<Menu> middleCategoryList = menuRepository.findMiddleCategoryList(largeCategory.getMenuId());
//            middleCategoryList.forEach(middleCategory -> {
//                System.out.println("middleCategory = " + middleCategory);
//                List<Menu> smallCategoryList = menuRepository.findSmallCategoryList(middleCategory.getMenuId());
//                smallCategoryList.forEach(smallCategory -> {
//                    System.out.println("smallCategory = " + smallCategory);
//                });
//            });
//        });
//    }
//
//}
