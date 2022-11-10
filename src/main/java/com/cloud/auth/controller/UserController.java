package com.cloud.auth.controller;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> getUserDetail(@RequestParam(value = "user_id") String UserId) {
        return new ResponseEntity<>(userService.getUserDetailInfo(UserId), HttpStatus.CREATED);
    }
}

