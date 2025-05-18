package com.nesrux.organizer.infrastructure.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.category.CategoryGateway;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryGateway service;

    public CategoryController(CategoryGateway service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable String id) {
        var category = service.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public List<Category> findAll() {
        var categories = service.listCategories();
        return categories;
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        var saved = service.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody Category category) {
        var updated = service.saveCategory(category);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
