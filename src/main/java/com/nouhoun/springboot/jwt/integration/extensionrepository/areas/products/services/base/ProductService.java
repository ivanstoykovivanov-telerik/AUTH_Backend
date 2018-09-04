package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.services.base;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();

    Product findById(long id);

    Product addProduct(ProductDTO product);

    Product updateProduct(long id, Product updateProduct);

    void deleteProduct(long id);
}
