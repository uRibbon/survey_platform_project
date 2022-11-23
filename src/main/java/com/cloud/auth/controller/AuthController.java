package com.cloud.auth.controller;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="v1/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

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
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userDto) {
        AccessTokenResponse response = authService.setAuth(userDto);
        return ResponseEntity.ok(response);
    }
    // refresh token
    @PostMapping(path = "/refresh_token")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {
        AccessTokenResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }

}
