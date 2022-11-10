package com.cloud.analysis.repository;

import com.cloud.analysis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
