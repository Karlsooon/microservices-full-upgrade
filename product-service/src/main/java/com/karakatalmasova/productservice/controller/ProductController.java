package com.karakatalmasova.productservice.controller;

import com.karakatalmasova.productservice.dto.ProductRequest;
import com.karakatalmasova.productservice.dto.ProductResponse;
import com.karakatalmasova.productservice.model.Product;
import com.karakatalmasova.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
