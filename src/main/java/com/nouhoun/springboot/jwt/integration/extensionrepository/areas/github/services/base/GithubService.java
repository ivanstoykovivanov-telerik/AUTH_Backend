package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.github.services.base;


import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;

import java.io.IOException;

public interface GithubService {
    void saveGithubProductInfo(Product product) throws IOException;
}
