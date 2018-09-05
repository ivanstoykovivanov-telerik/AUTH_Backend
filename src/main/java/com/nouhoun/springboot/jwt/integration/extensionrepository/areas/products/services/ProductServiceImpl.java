package com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.services;

import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.models.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.enums.StorageType;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.models.File;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.files.services.base.StorageService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.github.services.base.GithubService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.data.ProductsRepository;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.Product;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.models.dto.ProductDTO;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.products.services.base.ProductService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.areas.users.services.base.UserService;
import com.nouhoun.springboot.jwt.integration.extensionrepository.exceptions.FormatExeption;
import com.nouhoun.springboot.jwt.integration.extensionrepository.exceptions.InvalidArgumentExeption;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductsRepository productsRepository;
    private GithubService githubService;
    private UserService userService;
    private StorageService storageService;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository,
                              GithubService githubService,
                              UserService userService,
                              StorageService storageService) {
        this.productsRepository = productsRepository;
        this.githubService = githubService;
        this.userService = userService;
        this.storageService = storageService;
    }

    @Override
    public List<Product> listAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Product findById(long id) {
//        return productsRepository
//                .findById(id)
//                .orElseThrow(() -> new ProductNotFoundExeption("Cannot find product with id = " + id));
    return null;
    }

    @Override
    public Product addProduct(ProductDTO productDTO) {
        validateProduct(productDTO);
        Product product = bindProductDTOtoProduct(productDTO);
        product.setUploadDate(new Date());
        product.setProductState("pending");
        product.setNumberOfDownloads(0);
        addGithubInfo(product);
        return productsRepository.saveAndFlush(product);
    }

    @Override
    public Product updateProduct(long id, Product updateProduct) {
//        validateProduct(updateProduct);
        return productsRepository.saveAndFlush(updateProduct);
    }

    @Override
    public void deleteProduct(long id) {
//        productsRepository.deleteById(id);
    }

    private void addGithubInfo(Product product) {
        try {
            githubService.saveGithubProductInfo(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateProduct(ProductDTO product) {
        List<Product> products = productsRepository.findAll();
        boolean isNamePresent = products.stream().anyMatch(p -> p.getName().equals(product.getName()));
        boolean isRepositoryLinkPresent = products.stream()
                .anyMatch(p -> p.getSourceRepositoryLink().equals(product.getSourceRepositoryLink()));

        if (isNamePresent) {
            //Exeption type???
            throw new InvalidArgumentExeption("Product name already exist");
        }
        if (isRepositoryLinkPresent) {
            throw new InvalidArgumentExeption("Source repository link already exist");
        }
    }

    private Product bindProductDTOtoProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setVersion(productDTO.getVersion());

        User2 user = userService.findById(productDTO.getOwnerId());
        product.setOwner(user);

        product.setSourceRepositoryLink(productDTO.getSourceRepositoryLink());

        product.setTags(productDTO.getTags());

        File file = storageService.getById(productDTO.getFileId());
        if (!file.getType().equals(StorageType.FILE.name())){
            throw new FormatExeption("Not a file.");
        }
        product.setFile(file);
        product.setDownloadLink(file.getDownloadLink());

        File productImage = storageService.getById(productDTO.getProductPictureId());
        if (productImage == null) {
            // user default picture
        } else {
            if (!productImage.getType().equals(StorageType.IMAGE.name())){
                throw new FormatExeption("Not an image.");
            }
            product.setProductPicture(productImage);
        }
        return product;
    }
}
