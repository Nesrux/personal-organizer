package com.nesrux.organizer.infrastructure.api.controllers;

import java.util.List;

import com.nesrux.organizer.infrastructure.api.models.category.CategoryInputDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.category.CategoryGateway;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryListDTO;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryOutput;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryGateway service;

    public CategoryController(final CategoryGateway service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryOutput> findById(@PathVariable String id) {
        var category = service.getCategoryById(id);
        return ResponseEntity.ok(CategoryOutput.with(category));
    }

    @GetMapping
    public List<CategoryListDTO> findAll() {
        var categories = service.listCategories();
        return categories.stream().map(CategoryListDTO::fromDomain).toList();
    }

    @PostMapping
    public ResponseEntity<CategoryOutput> save(@RequestBody CategoryInputDto category) {
        var saved = service.saveCategory(category.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryOutput.with(saved));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
