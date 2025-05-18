package com.nesrux.organizer.services;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.domain.models.task.TaskGateway;
import com.nesrux.organizer.domain.exceptions.EntityNotFoundException;
import com.nesrux.organizer.infrastructure.persistence.models.CategoryJpaEntity;
import com.nesrux.organizer.infrastructure.persistence.models.TaskJpaEntity;
import com.nesrux.organizer.infrastructure.persistence.repositories.TaskRepository;

@Service
public class TaskService implements TaskGateway {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    
    @Override
    @Transactional
    public Task saveTask(Task task) {
        var categoryJpa = CategoryJpaEntity.toEntity(task.getCategory());
        var entity = TaskJpaEntity.toEntity(task, categoryJpa);
        return repository.save(entity).toDomain();
    }

    @Override
    @Transactional
    public Task findTaskById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id))
                .toDomain();
    }

    @Override
    @Transactional
    public void deleteTaskById(String id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Task> listTasks() {
        return repository.findAll()
                .stream()
                .map(TaskJpaEntity::toDomain)
                .toList();
    }


 

}
