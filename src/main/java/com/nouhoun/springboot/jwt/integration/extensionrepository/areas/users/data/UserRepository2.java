package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;

@Repository
public interface UserRepository2 extends JpaRepository<User2, Long> {
}
