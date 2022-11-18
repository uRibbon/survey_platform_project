package com.cloud.auth.controller;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;


@RestController
@RequestMapping(value="v1/user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RolesAllowed({ "USER" })
    @RequestMapping(value = "/keycloakTest", method = RequestMethod.GET)
    public String keyclakTest(Principal principal, @RequestParam(value = "user_id") String UserId) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal; //jwt로 형변환
        return token.getTokenAttributes().toString();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserDetail(@RequestParam(value = "user_id") String UserId) {
        return new ResponseEntity<>(userService.getUserDetailInfo(UserId), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/kafkaConnTest", method = RequestMethod.POST)
    public String sendMessage(@RequestParam("message") String message) {
        return userService.doKafkaConnTest(message);
    }

}
