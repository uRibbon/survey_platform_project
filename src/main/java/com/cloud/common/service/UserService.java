package com.cloud.common.service;

import com.cloud.common.entity.User;
import com.cloud.common.dto.UserDTO;

public interface UserService {
    void insertUser(UserDTO userDTO);
    UserDTO readUser(String userId);

    default UserDTO entityToDTO(User user) {
        UserDTO userDTO = UserDTO.builder()
                .userId(user.getUserId())
                .userPwd(user.getUserPwd())
                .name(user.getName())
                .job(user.getJob())
                .age(user.getAge())
                .gender(user.getGender())
                .phone(user.getPhone())
                .mailAddr(user.getMailAddr())
                .isMailAccept(user.getIsMailAccept())
                .isPhoneAccept(user.getIsPhoneAccept())
                .role(user.getRole())
                .regId(user.getRegId())
                .regDt(user.getRegDt())
                .useYn(user.getUseYn())
                .build();
        return userDTO;
    }

    default User dtoToEntity(UserDTO userDTO) {
        User user = User.builder()
                .userId(userDTO.getUserId())
                .userPwd(userDTO.getUserPwd())
                .name(userDTO.getName())
                .job(userDTO.getJob())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .phone(userDTO.getPhone())
                .mailAddr(userDTO.getMailAddr())
                .isMailAccept(userDTO.getIsMailAccept())
                .isPhoneAccept(userDTO.getIsPhoneAccept())
                .role(userDTO.getRole())
                .regId(userDTO.getRegId())
                .regDt(userDTO.getRegDt())
                .useYn(userDTO.getUseYn())
                .build();
        return user;
    }
}
