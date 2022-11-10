package com.cloud.auth.service;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.entity.User;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;


public interface UserService {


    UserDTO getUserDetailInfo(String UserId); // 사용자 정보 조회

}
