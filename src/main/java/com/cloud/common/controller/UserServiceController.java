package com.cloud.common.controller;

import com.cloud.common.dto.UserDTO;
import com.cloud.common.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value="v1/common")
@AllArgsConstructor
public class UserServiceController {
    @Autowired
    private final UserService userService;

    @PostMapping("/user")
    public void insertUser(UserDTO userDTO) {
        userService.insertUser(userDTO);
    }

    @GetMapping("/user/{userId}")
    public UserDTO getUser(@PathVariable String userId) {
        UserDTO userDTO = userService.readUser(userId);
        return userDTO;
    }
}
