package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.data.UserRepository2;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.UserDTO;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base.UserService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.validators.UserValidator2;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final String PENDING_USER_STATUS = "pending";

    @Autowired
    private UserRepository2 userRepository;

    @Autowired
    public UserServiceImpl(UserRepository2 userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User2> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User2 findById(long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundExeption(
//                        String.format("Can't find user with id = %d", id)));
    return null;
    }

    @Override
    public User2 addUser(UserDTO userDTO) {
        User2 user = bindUserDTOtoUser(userDTO);
        user.setUserStatus(PENDING_USER_STATUS);
        checkUser(user);
        return userRepository.save(user);
    }

    private void checkUser(User2 user) {
        UserValidator2 userValidator = new UserValidator2();
        userValidator.checkUserDataFormat(user);

        List<User2> users = listAllUsers();

        for (User2 u : users) {
            if (u.getEmail().equals(user.getEmail())){
                throw new IllegalArgumentException("Email already exists.");
            }
            if (u.getUsername().equals(user.getUsername())){
                throw new IllegalArgumentException("Username already exists.");
            }
        }
    }

    @Override
    public User2 updateUser(long id, User2 updateUser) {
        findById(id);
        return userRepository.save(updateUser);
    }

    @Override
    public void deleteUser(long id) {
//        findById(id);
//        userRepository.deleteById(id);
    }

    @Override
    public List<Product> listAllProducts(long id) {
        List<Product> products = findById(id).getProducts();
        return products;
    }

    private User2 bindUserDTOtoUser(UserDTO userDTO){
        User2 user = new User2();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setProducts(userDTO.getProducts());
        return user;
    }
}