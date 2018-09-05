package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.exeptions.ProductNotFoundExeption;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.services.base.ProductService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.models.Tag;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.models.dto.TagDTO;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.services.base.TagsService;

import java.util.List;

@RestController
@RequestMapping("/springjwt/products/tags")
public class ProductsTagsController {
    private ProductService productService;
    private TagsService tagsService;

    @Autowired
    public ProductsTagsController(ProductService productService, TagsService tagsService) {
        this.productService = productService;
        this.tagsService = tagsService;
    }

    @PostMapping("/add/{id}")
    public @ResponseBody
    void addProductTags(@PathVariable("id") long id, @RequestBody List<TagDTO> inputTags){
        Product product = productService.findById(id);
        List<Tag> tags = tagsService.addTags(inputTags);
        product.setTags(tags);
    }

    @ExceptionHandler(ProductNotFoundExeption.class)
    public String catchProductNotFoundExeption(){
        return "Product Not Found!";
    }
}
