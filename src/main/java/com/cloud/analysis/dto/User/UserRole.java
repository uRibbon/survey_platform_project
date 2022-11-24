package com.cloud.analysis.dto.User;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {

    ADMIN("관리자"),
    USER("사용자");

    private final String title;
    public String getCode() {
        return name();
    }
}
