package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Survey;
import com.cloud.analysis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void read(){
        List<User> userList = userRepository.findAll();
        userList.forEach(survey -> {
            System.out.println("user = " + survey);
        });
    }
}