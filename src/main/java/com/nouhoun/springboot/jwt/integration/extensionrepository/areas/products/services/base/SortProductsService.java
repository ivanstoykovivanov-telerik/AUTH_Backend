package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.services.base;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;

import java.util.List;

public interface SortProductsService {

    List<Product> findAllSortedByName();

    List<Product> findAllSortedByNumberOfDownloadsDesc();

    List<Product> findAllSortedByUploadDateDesc();

    List<Product> findAllSortedByLastCommitDateDesc();

    List<Product> findTop10SortedByNumberOfDownloadsDesc();

    List<Product> findTop10SortedByUploadDateDesc();
}
