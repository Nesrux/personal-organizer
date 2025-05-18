package com.nesrux.organizer.infrastructure.api.controllers;

import java.util.List;

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

    public TaskController(TaskGateway service) {
        this.service = service;
        System.out.println("teste");
        System.out.println("teste");
        System.out.println("teste");
        System.out.println("teste");
        System.out.println("teste");

    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskOutputDto> findById(@PathVariable String id) {
        var task = service.findTaskById(id);
        return ResponseEntity.ok(TaskOutputDto.with(task));
    }

    @GetMapping
    public List<TaskListDTO> findAll() {
        var tasks = service.listTasks();
        System.out.println("testeaaa");
        System.out.println("testeaaaaaa");
        System.out.println("testeaaaaa");
        System.out.println("testeaaaa");
        System.out.println("testeaa");

        return tasks.stream().map(TaskListDTO::fromDomain).toList();
    }

    @PostMapping
    public ResponseEntity<TaskOutputDto> save(@RequestBody TaskInputDto task) {
        var saved = service.saveTask(task.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskOutputDto.with(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
