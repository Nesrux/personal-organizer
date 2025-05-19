package com.nesrux.organizer.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesrux.organizer.infrastructure.persistence.models.TaskJpaEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskJpaEntity, String> {
    @Query("SELECT t FROM TaskJpaEntity t WHERE t.active = true")
    List<TaskJpaEntity> findAllActiveTasks();

}
