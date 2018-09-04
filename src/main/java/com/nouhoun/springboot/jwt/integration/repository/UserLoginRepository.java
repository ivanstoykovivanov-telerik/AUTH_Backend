package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserLoginRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User save(User user);

}
