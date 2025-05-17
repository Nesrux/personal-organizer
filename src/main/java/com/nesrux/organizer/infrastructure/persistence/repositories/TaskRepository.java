package com.nesrux.organizer.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesrux.organizer.infrastructure.persistence.models.TaskJpaEntity;

public interface TaskRepository extends JpaRepository<TaskJpaEntity, String> {

}
