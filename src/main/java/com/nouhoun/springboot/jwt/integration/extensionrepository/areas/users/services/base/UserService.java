package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.UserDTO;

import java.util.List;

public interface UserService {
    List<User2> listAllUsers();

    User2 findById(long id);

    User2 addUser(UserDTO user);

    User2 updateUser(long id, User2 updateUser);

    void deleteUser(long id);

    List<Product> listAllProducts(long id);
}
