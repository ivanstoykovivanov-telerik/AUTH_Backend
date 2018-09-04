package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByName();

    List<Product> findAllByOrderByNumberOfDownloadsDesc();

    List<Product> findAllByOrderByUploadDateDesc();

    List<Product> findAllByOrderByLastCommitDateDesc();

    List<Product> findTop10ByOrderByNumberOfDownloadsDesc();

    List<Product> findTop10ByOrderByUploadDateDesc();
}