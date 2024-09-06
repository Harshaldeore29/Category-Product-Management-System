package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.entity.Product;
import com.springboot.repository.CategoryRepository;
import com.springboot.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    @Operation(summary = "Get all products", description = "List all products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PostMapping
    @Operation(summary = "Create a product", description = "Add a new product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (categoryRepo.existsById(product.getCategory().getId())) {
            return ResponseEntity.ok(productRepo.save(product));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Get product details by ID")
    public ResponseEntity<Product> getProductById(@Parameter(description = "Product ID", required = true) @PathVariable Long id) {
        return productRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product by ID", description = "Update product by its ID")
    public ResponseEntity<Product> updateProduct(
            @Parameter(description = "Product ID to update", required = true) @PathVariable Long id,
            @RequestBody Product product) {
        if (productRepo.existsById(id) && categoryRepo.existsById(product.getCategory().getId())) {
            product.setId(id);
            return ResponseEntity.ok(productRepo.save(product));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by ID", description = "Delete a product by its ID")
    public ResponseEntity<Void> deleteProduct(@Parameter(description = "Product ID to delete", required = true) @PathVariable Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
