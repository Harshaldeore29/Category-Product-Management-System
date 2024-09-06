package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.entity.Category;
import com.springboot.repository.CategoryRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category Management", description = "APIs for managing categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping
    @Operation(summary = "Get all categories", description = "List all categories")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryRepo.findAll());
    }

    @PostMapping
    @Operation(summary = "Create a new category", description = "Add a new category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryRepo.save(category));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get category by ID", description = "Get category details by ID")
    public ResponseEntity<Category> getCategoryById(
            @Parameter(description = "Category ID", required = true) @PathVariable Long id) {
        return categoryRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update category by ID", description = "Update category by its ID")
    public ResponseEntity<Category> updateCategory(
            @Parameter(description = "Category ID to update", required = true) @PathVariable Long id,
            @RequestBody Category category) {
        if (!categoryRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
        return ResponseEntity.ok(categoryRepo.save(category));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete category by ID", description = "Delete category by its ID")
    public ResponseEntity<Void> deleteCategory(
            @Parameter(description = "Category ID to delete", required = true) @PathVariable Long id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
