package com.cloud.point.repository;

import com.cloud.point.entity.User;
import com.cloud.point.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void read() {
        List<User> userList = userRepository.findAll();
        userList.forEach(user -> {
            System.out.println("user = " + user.toString());
        });
    }

    @Test
    void insert() {
        User user = User.builder()
                .userId("Stella")
                .userPwd("aa11")
                .name("YR")
                .job("student")
                .age(23)
                .gender(true)
                .phone("01012345678")
                .mailAddr("yurie@gachon.ac.kr")
                .isMailAccept(true)
                .isPhoneAccept(true)
                .role(Role.MEMBER)
                .regId("Yurie")
                .regDt(LocalDateTime.now())
                .useYn(true)
                .build();
        userRepository.save(user);
    }

}
