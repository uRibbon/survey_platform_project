package com.cloud.common.repository;

import com.cloud.common.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepoitory extends JpaRepository<QuestionType, Integer> {
}
