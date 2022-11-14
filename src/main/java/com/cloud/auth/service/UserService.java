package com.cloud.auth.service;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.entity.User;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;


public interface UserService {

    String doKafkaConnTest (String message); // 카프카 커넥트 테스트

    UserDTO getUserDetailInfo(String UserId); // 사용자 정보 조회

}
