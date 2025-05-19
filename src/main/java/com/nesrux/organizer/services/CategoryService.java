package com.nesrux.organizer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.category.CategoryGateway;
import com.nesrux.organizer.domain.exceptions.EntityNotFoundException;
import com.nesrux.organizer.infrastructure.persistence.models.CategoryJpaEntity;
import com.nesrux.organizer.infrastructure.persistence.repositories.CategoryRepository;

@Service
public class CategoryService implements CategoryGateway {

    private final CategoryRepository repository;

    public CategoryService(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category getCategoryById(final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id))
                .toDomain();
    }

    @Override
    public void deleteCategoryById(final String id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        repository.deleteById(id);
    }

    @Override
    public Category saveCategory(final Category category) {
        var entity = CategoryJpaEntity.toEntity(category);

        return repository.save(entity).toDomain();
    }

    @Override
    public Category updateCategory(final Category category) {
        var savedCategory = getCategoryById(category.getId());
        return savedCategory.update(category.getName());
    }

    @Override
    public List<Category> listCategories() {
        return repository.findAll()
                .stream()
                .map(CategoryJpaEntity::toDomain)
                .toList();
    }

}
