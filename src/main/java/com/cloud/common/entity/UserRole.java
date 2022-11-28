package com.cloud.common.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {

    ADMIN("관리자"),
    USER("사용자"),
    ALL("전체");

    private final String title;
    public String getCode() {
        return name();
    }
}
