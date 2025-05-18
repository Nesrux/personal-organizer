package com.nesrux.organizer.infrastructure.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.domain.models.task.TaskGateway;

public class TaskController {

    private final TaskGateway service;

    public TaskController(TaskGateway service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id) {
        var task = service.findTaskById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public List<Task> findAll() {
        var tasks = service.listTasks();
        return tasks;
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        var saved = service.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable String id, @RequestBody Task task) {
        var updated = service.saveTask(task);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
