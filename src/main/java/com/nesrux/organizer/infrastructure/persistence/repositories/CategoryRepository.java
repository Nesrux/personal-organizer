package com.nesrux.organizer.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesrux.organizer.infrastructure.persistence.models.CategoryJpaEntity;

public interface CategoryRepository extends JpaRepository<CategoryJpaEntity, String> {

}
