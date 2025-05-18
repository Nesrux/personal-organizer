package com.nesrux.organizer.domain.models.task;

import java.util.List;

public interface TaskGateway {
    Task saveTask(Task task);

    Task findTaskById(String id);

    void deleteTaskById(String id);

    List<Task> listTasks();

}
