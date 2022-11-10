package com.cloud.common.repository;

import com.cloud.common.entity.User;
import com.cloud.common.entity.Role;
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
                .userId("yena1")
                .userPwd("djfsldfjlksdjf")
                .name("yena")
                .job("student")
                .age(25)
                .gender(true)
                .phone("01012345678")
                .mailAddr("yena@gachon.ac.kr")
                .isMailAccept(true)
                .isPhoneAccept(true)
                .role(Role.MEMBER)
                .regId("yena")
                .regDt(LocalDateTime.now())
                .useYn(true)
                .build();
        userRepository.save(user);
    }

}
