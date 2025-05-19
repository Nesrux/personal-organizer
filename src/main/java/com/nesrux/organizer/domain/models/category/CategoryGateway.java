package com.nesrux.organizer.domain.models.category;

import java.util.List;

public interface CategoryGateway {

    Category getCategoryById(final String id);

    void deleteCategoryById(final String id);

    Category saveCategory(final Category category);

    Category updateCategory(final Category category);

    List<Category> listCategories();
}
