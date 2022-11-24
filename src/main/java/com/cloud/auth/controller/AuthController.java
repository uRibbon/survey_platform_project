package com.cloud.auth.controller;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.service.AuthService;
import com.cloud.auth.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value="v1/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity registerUser(@RequestBody UserDTO userDto) {
        if(authService.existsByUsername(userDto.getUserId())) {
            return ResponseEntity.ok("유저가 존재합니다.");
        }
        UserDTO result = authService.createUser(userDto);
        return ResponseEntity.ok(result);
    }

    // 로그인
    @PostMapping(path = "/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody HashMap<String, String> map) {
        AccessTokenResponse tokenRes = authService.setAuth(map);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("token", tokenRes);
        if(tokenRes != null){
            data.put("info", userService.getUserDetailInfo(map.get("username")));
        }
        Map<String, Object> resultmap = new HashMap<String, Object>();
        resultmap.put("data", data);
        return ResponseEntity.ok(resultmap);
    }


    // refresh token
    @PostMapping(path = "/refresh_token")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {
        AccessTokenResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }

}
