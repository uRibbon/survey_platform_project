package com.cloud.common.service;

import com.cloud.common.entity.User;
import com.cloud.common.dto.UserDTO;
import com.cloud.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public void insertUser(UserDTO userDTO) {
        userRepository.save(dtoToEntity(userDTO));
    }

    @Override
    public UserDTO readUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return entityToDTO(user);
    }
}

