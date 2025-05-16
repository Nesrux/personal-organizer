package com.nesrux.organizer.domain.models.category;

import java.time.Instant;
import java.util.List;

import com.nesrux.organizer.domain.models.task.Task;

public class Category {
    private String id;
    private String name;
    private List<Task> tasks;
    private Instant createdAt;
    private Instant updatedAt;
    
}
