package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.UserDTO;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();

    User findById(long id);

    User addUser(UserDTO user);

    User updateUser(long id, User updateUser);

    void deleteUser(long id);

    List<Product> listAllProducts(long id);
}
