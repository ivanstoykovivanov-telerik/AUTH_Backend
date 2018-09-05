package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.admin.services;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.admin.services.base.AdminService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.services.base.ProductService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
    private static final String APPROVED_USER_STATUS = "approved";

    private UserService userService;
    private ProductService productService;

    @Autowired
    public AdminServiceImpl(ProductService productService,
                            UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void changeUserStatus(String status, long id) {
        User2 user = userService.findById(id);
        user.setUserStatus(status);
    }

    @Override
    public void approveProduct(long id) {
        Product product = productService.findById(id);
        product.setProductState("approved");
    }
}
