package com.cloud.auth.service;

import com.cloud.auth.dto.UserDTO;
import com.cloud.auth.entity.User;
import com.cloud.auth.repository.UserRepository;
import com.cloud.auth.service.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper mapper;

    private final KafkaProducer kafkaProducer;

    @Override
    public String doKafkaConnTest(String message) {
        kafkaProducer.sendMessage("test", message);
        return "success";
    }

    public UserDTO getUserDetailInfo(String UserId) {
        User user = userRepository.findByUserId(UserId);
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUserDetailInfoList(List<Map<String, Object>> list) {
        List<UserDTO> userList = new ArrayList<>();
        list.forEach(user -> {
            userList.add(getUserDetailInfo((String) user.get("reg_id")));
        });
        return userList;
    }
}
