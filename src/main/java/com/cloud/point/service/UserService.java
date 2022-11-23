package com.cloud.point.service;

import com.cloud.point.dto.UserDTO;

public interface UserService {
    UserDTO getUserDetailInfo(String UserId);
}