package com.cloud.auth.service;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.entity.User;
import com.cloud.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper mapper;
    @Override
    public UserDTO getUserDetailInfo(String UserId) {
        User user = userRepository.findByUserId(UserId);
        return mapper.map(user, UserDTO.class);
    }
}
