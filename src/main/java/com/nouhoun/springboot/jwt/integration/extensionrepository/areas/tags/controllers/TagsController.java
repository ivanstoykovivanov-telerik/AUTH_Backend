package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.exeptions.TagNotFoundExeption;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.models.Tag;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.models.dto.TagDTO;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.tags.services.base.TagsService;

import java.util.List;

@RestController
@RequestMapping("/springjwt/tags")
public class TagsController  {
    private TagsService tagsService;

    @Autowired
    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping
    public List<Tag> listAllTags(){
        return tagsService.listAll();
    }

    @PostMapping("/add")
    public @ResponseBody
    Tag add(@RequestBody TagDTO tagDTO){
        return tagsService.add(tagDTO);
    }

    @PutMapping("/update")
    public void update(@RequestBody Tag tag){
        tagsService.update(tag);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        tagsService.delete(id);
    }

    @GetMapping("/products")
    public List<Product> listAllProducts(String tagname){
        return tagsService.listAllProducts(tagname);
    }

    @ExceptionHandler(TagNotFoundExeption.class)
    public String catchUserNotFoundExeption(){
        return "Tag Not Found.";
    }
}
