package com.nesrux.organizer.infrastructure.api.controllers;

import java.util.List;

import com.nesrux.organizer.domain.models.category.CategoryGateway;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nesrux.organizer.domain.models.task.TaskGateway;
import com.nesrux.organizer.infrastructure.api.models.task.TaskInputDto;
import com.nesrux.organizer.infrastructure.api.models.task.TaskListDTO;
import com.nesrux.organizer.infrastructure.api.models.task.TaskOutputDto;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskGateway service;
    private final CategoryGateway categoryGateway;

    public TaskController(final TaskGateway service, final CategoryGateway categoryGateway) {
        this.service = service;
        this.categoryGateway = categoryGateway;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskOutputDto> findById(@PathVariable String id) {
        var task = service.findTaskById(id);
        return ResponseEntity.ok(TaskOutputDto.with(task));
    }

    @GetMapping
    public List<TaskListDTO> findAll() {
        var tasks = service.listTasks();
        return tasks.stream().map(TaskListDTO::fromDomain).toList();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TaskOutputDto> save(@RequestBody TaskInputDto taskDto) {
        System.out.println(taskDto.categoryId());
        System.out.println(taskDto.categoryId());
        System.out.println(taskDto.categoryId());

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
