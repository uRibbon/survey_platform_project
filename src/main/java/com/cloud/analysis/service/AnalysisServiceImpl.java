package com.cloud.analysis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    private final AnswerRepository answerRepository;

    @Override
    public List<Object> getUserAnswerList(Integer surId) {
        List<Object> allList = new ArrayList<>();
        List<User> userList = answerRepository.findAnswerBySurvey(surId);
        userList.forEach(user -> {
            List<Object> userAnswerList = new ArrayList<>();
            userAnswerList.add(user);
            List<Answer> answerList = answerRepository.findAnswerByUser(user.getUserId());
            userAnswerList.add(answerList);
            allList.add(userAnswerList);
        });
        return allList;
    }
}
