package com.cloud.analysis.repository;

import com.cloud.analysis.entity.Vulgarism.SurveyVulgarism;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VulgarismRepository extends JpaRepository<SurveyVulgarism, Integer> {
}
