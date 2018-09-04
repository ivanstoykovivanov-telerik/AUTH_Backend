package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
