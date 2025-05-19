package com.nesrux.organizer.infrastructure.api.controllers;

import com.nesrux.organizer.domain.models.category.CategoryGateway;
import com.nesrux.organizer.infrastructure.api.docs.CategoryApi;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryIdInput;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryInputDto;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryListDTO;
import com.nesrux.organizer.infrastructure.api.models.category.CategoryOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@CrossOrigin("*")
public class CategoryController implements CategoryApi {

    private final CategoryGateway service;

    public CategoryController(final CategoryGateway service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<CategoryOutput> findById(final CategoryIdInput inputId) {
        var category = service.getCategoryById(inputId.id());
        return ResponseEntity.ok(CategoryOutput.with(category));
    }

    @Override
    public List<CategoryListDTO> findAll() {
        var categories = service.listCategories();
        return categories.stream().map(CategoryListDTO::fromDomain).toList();
    }

    @Override
    public ResponseEntity<CategoryOutput> save(final CategoryInputDto category) {
        var saved = service.saveCategory(category.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryOutput.with(saved));
    }


    @Override
    public ResponseEntity<Void> delete(final CategoryIdInput inputId) {
        service.deleteCategoryById(inputId.id());
        return ResponseEntity.noContent().build();
    }
}
