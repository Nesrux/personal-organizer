package com.nesrux.organizer.infrastructure.api.controllers;

import com.nesrux.organizer.domain.models.category.CategoryGateway;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.domain.models.task.TaskGateway;
import com.nesrux.organizer.infrastructure.api.docs.TaskApi;
import com.nesrux.organizer.infrastructure.api.models.task.TaskInputDto;
import com.nesrux.organizer.infrastructure.api.models.task.TaskInputId;
import com.nesrux.organizer.infrastructure.api.models.task.TaskListDTO;
import com.nesrux.organizer.infrastructure.api.models.task.TaskOutputDto;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@CrossOrigin("*")
public class TaskController implements TaskApi {

    private final TaskGateway service;
    private final CategoryGateway categoryGateway;

    public TaskController(final TaskGateway service, final CategoryGateway categoryGateway) {
        this.service = service;
        this.categoryGateway = categoryGateway;
    }

    @Override
    public ResponseEntity<TaskOutputDto> findById(final TaskInputId inputId) {
        var task = service.findTaskById(inputId.id());
        return ResponseEntity.ok(TaskOutputDto.with(task));
    }

    @Override
    @GetMapping
    public List<TaskListDTO> findAll() {
        var tasks = service.listTasks();
        return tasks.stream().map(TaskListDTO::fromDomain).toList();
    }

    @Override
    @Transactional
    public ResponseEntity<TaskOutputDto> save(final TaskInputDto taskDto) {
        var category = categoryGateway.getCategoryById(taskDto.categoryId());

        var task = Task.create(
                taskDto.title(),
                taskDto.description(),
                Frequency.fromString(taskDto.frequency()),
                category
        );

        var saved = service.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskOutputDto.with(saved));
    }

    @Override
    public ResponseEntity<Void> delete(final TaskInputId inputId) {
        service.deleteTaskById(inputId.id());
        return ResponseEntity.noContent().build();
    }
}
