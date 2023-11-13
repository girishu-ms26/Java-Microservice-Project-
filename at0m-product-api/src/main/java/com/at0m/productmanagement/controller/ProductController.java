package com.at0m.productmanagement.controller;

import com.at0m.common.model.Product;
import com.at0m.common.model.ProductResponseResource;
import com.at0m.common.service.ProductService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponseResource> getAllProductsList(
            @RequestHeader(value = "apiKey", required = true) String apiKey){
        return productService.getAllProductsList();
    }

    @GetMapping("/products/{productName}")
    public ProductResponseResource getProductByproductName(
            @RequestHeader(value = "apiKey", required = true) String apiKey,
            @PathVariable @Valid String productName){
        return productService.getProductByproductName(productName);
    }

    @PostMapping("/products")
    public List<ProductResponseResource> saveProduct(
            @RequestHeader(value = "apiKey", required = true) String apiKey,
            @RequestBody @Valid Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/products/")
    public List<ProductResponseResource> saveListOfProducts(
            @RequestHeader(value = "apiKey", required = true) String apiKey,
            @RequestBody @Valid List<Product> products){
        return productService.saveListOfProducts(products);
    }

    @DeleteMapping("/products")
    public List<ProductResponseResource> deleteAllProducts(
            @RequestHeader(value = "apiKey", required = true) String apiKey){
        return productService.deleteAll();
    }

    @PutMapping("/products")
    public List<ProductResponseResource> updateProduct(
            @RequestHeader(value = "apiKey", required = true) String apiKey,
            @RequestBody @Valid List<Product> products){
        return productService.updateProduct(products);
    }

    @DeleteMapping("/products/{productName}")
    public void deleteProduct(
            @RequestHeader(value = "apiKey", required = true) String apiKey,
            @PathVariable String productName){
        productService.deleteProduct(productName);
    }

}