package com.nesrux.organizer;

import java.util.concurrent.ThreadLocalRandom;

import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;

public final class MockDomain {

    private static final Category category_one = Category.create("to clean");
    private static final Category category_two = Category.create("studies");

    private static final Task task_one = Task.create("limpeza", "limpar toda a casa", Frequency.WEEKLY, category_one);
    private static final Task task_two = Task.create("Estudar", "Estudar a matéria acumulada", Frequency.DAILY,
            category_two);

    private MockDomain() {
    }

    public static Category categoryMock() {
        return ThreadLocalRandom.current().nextBoolean() ? category_one : category_two;
    }

    public static Task taskMock() {
        return ThreadLocalRandom.current().nextBoolean() ? task_one : task_two;
    }

}
