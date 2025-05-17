package com.nesrux.organizer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nesrux.organizer.MockDomain;
import com.nesrux.organizer.domain.exceptions.DomainException;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;

public class TaskTest {

    @Test
    public void givenAvalidParams_whenCallsCreateTask_thenReturnAvalidTask() {
        // given
        final var title = "Pagar a mensalidade da faculdade";
        final var description = "sacar o dinheiro no caixa eletronico, pegar o boleto da faculdade e depois ir na lotérica";
        final var frequency = Frequency.MONTHLY;
        final var category = MockDomain.categoryMock();

        // when
        final var task = Task.create(title, description, frequency, category);

        // then
        Assertions.assertEquals(title, task.getTitle());
        Assertions.assertEquals(description, task.getDescription());
        Assertions.assertEquals(frequency, task.getFrequency());
        Assertions.assertEquals(category, task.getCategory());
        Assertions.assertNotNull(task.getId());
        Assertions.assertNotNull(task.getCreatedAt());
        Assertions.assertNotNull(task.getUpdatedAt());
        Assertions.assertNull(task.getDeletedAt());
        Assertions.assertTrue(task.isActive());
    }

    @Test
    public void givenAnInvalidParams_whenCallsCreateTask_thenThrowException() {
        // given
        String title = null;
        final var description = "sacar o dinheiro no caixa eletronico, pegar o boleto da faculdade e depois ir na lotérica";
        final var frequency = Frequency.MONTHLY;
        final var category = MockDomain.categoryMock();
        final var message = "title not be null";

        // when
        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> Task.create(title, description, frequency, category));

        // then
        Assertions.assertEquals(message, actualException.getMessage());
    }

    @Test
    public void givenAnEmptyTitle_whenCallsCreateTask_thenThrowException() {
        // given
        String title = "";
        final var description = "sacar o dinheiro no caixa eletronico, pegar o boleto da faculdade e depois ir na lotérica";
        final var frequency = Frequency.MONTHLY;
        final var category = MockDomain.categoryMock();
        final var message = "title not be empty";

        // when
        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> Task.create(title, description, frequency, category));

        // then
        Assertions.assertEquals(message, actualException.getMessage());
    }

    @Test
    public void givenATitleWithInvalidCaracteres_whenCallsCreateTask_thenThrowException() {
        // given
        String title = "aaa";
        final var description = "sacar o dinheiro no caixa eletronico, pegar o boleto da faculdade e depois ir na lotérica";
        final var frequency = Frequency.MONTHLY;
        final var category = MockDomain.categoryMock();
        final var message = "title must have at least 4 characters";

        // when
        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> Task.create(title, description, frequency, category));

        // then
        Assertions.assertEquals(message, actualException.getMessage());
    }

    @Test
    public void givenAValidParms_whenCallsUpdateTask_thenToBeOk() {
        // given
        final var task = MockDomain.taskMock();
        final var id = task.getId();
        final var tile = task.getTitle();
        final var description = task.getDescription();
        final var category = task.getCategory();
        final var frequency = task.getFrequency();
        final var active = task.isActive();
        final var createdAt = task.getCreatedAt();
        final var updatedAt = task.getUpdatedAt();
        final var deletedAt = task.getDeletedAt();

        final var actualTitle = "tomar o remédio";
        final var actualDescription = "pegar o remédio na minha gaveta e tomar com 150ml de agua";
        final var actualFrequency = Frequency.MONTHLY;

        // when
        final var actualTask = task.update(actualTitle, actualDescription, actualFrequency);

        // then
        Assertions.assertEquals(task, actualTask);
        Assertions.assertEquals(id, actualTask.getId());
        Assertions.assertEquals(category, actualTask.getCategory());
        Assertions.assertEquals(active, actualTask.isActive());
        Assertions.assertEquals(createdAt, actualTask.getCreatedAt());
        Assertions.assertEquals(deletedAt, actualTask.getDeletedAt());
        Assertions.assertEquals(actualTitle, actualTask.getTitle());
        Assertions.assertEquals(actualDescription, actualTask.getDescription());
        Assertions.assertNotEquals(tile, actualTask.getTitle());
        Assertions.assertNotEquals(description, actualTask.getDescription());
        Assertions.assertNotEquals(frequency, actualTask.getFrequency());
        Assertions.assertTrue(actualTask.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNull(actualTask.getDeletedAt());
    }

    @Test
    public void givenAnEmptyDescription_whenCallsUpdateTask_thenThrowException() {
        // given
        final var task = MockDomain.taskMock();
        final var actualTitle = "tomar o remédio";
        final var actualDescription = "";
        final var actualFrequency = Frequency.MONTHLY;
        final var message = "description not be empty";
        // when
        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> task.update(actualTitle, actualDescription, actualFrequency));

        // then
        Assertions.assertEquals(message, actualException.getMessage());
    }

    @Test
    public void givenANullDescription_whenCallsUpdateTask_thenThrowException() {
        // given
        final var task = MockDomain.taskMock();
        final var actualTitle = "tomar o remédio";
        final String actualDescription = null;
        final var actualFrequency = Frequency.MONTHLY;
        final var message = "description not be null";
        // when
        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> task.update(actualTitle, actualDescription, actualFrequency));

        // then
        Assertions.assertEquals(message, actualException.getMessage());
    }

    @Test
    public void givenANullFrequency_whenCallsUpdateTask_thenThrowException() {
        // given
        final var task = MockDomain.taskMock();
        final var actualTitle = "tomar o remédio";
        final String actualDescription = "pegar o remédio na minha gaveta e tomar com 150ml de agua";
        final Frequency actualFrequency = null;
        final var message = "frequency not be null";
        // when
        final var actualException = Assertions.assertThrows(NullPointerException.class,
                () -> task.update(actualTitle, actualDescription, actualFrequency));

        // then
        Assertions.assertEquals(message, actualException.getMessage());
    }

    // Active deactive
    @Test
    public void givenAValidTaskWithActiveIsTrue_whenCallsActive_thenDoNothing() {
        // given
        final var task = MockDomain.taskMock();
        final var id = task.getId();
        final var title = task.getTitle();
        final var description = task.getDescription();
        final var category = task.getCategory();
        final var frequency = task.getFrequency();
        final var active = task.isActive();
        final var createdAt = task.getCreatedAt();
        final var updatedAt = task.getUpdatedAt();
        final var deletedAt = task.getDeletedAt();

        // when
        task.actvate();

        // then
        Assertions.assertEquals(id, task.getId());
        Assertions.assertEquals(category, task.getCategory());
        Assertions.assertEquals(active, task.isActive());
        Assertions.assertEquals(createdAt, task.getCreatedAt());
        Assertions.assertEquals(deletedAt, task.getDeletedAt());
        Assertions.assertEquals(title, task.getTitle());
        Assertions.assertEquals(description, task.getDescription());
        Assertions.assertEquals(frequency, task.getFrequency());
        Assertions.assertEquals(title, task.getTitle());
        Assertions.assertEquals(description, task.getDescription());
        Assertions.assertEquals(task.getUpdatedAt(), updatedAt);
        Assertions.assertNull(task.getDeletedAt());
    }

    @Test
    public void givenAValidTaskWithActiveIsTrue_whenCallsDeActive_thenDeactivateTask() {
        // given
        final var task = MockDomain.taskMock();
        final var id = task.getId();
        final var title = task.getTitle();
        final var description = task.getDescription();
        final var category = task.getCategory();
        final var frequency = task.getFrequency();
        final var active = task.isActive();
        final var createdAt = task.getCreatedAt();
        final var updatedAt = task.getUpdatedAt();
        final var deletedAt = task.getDeletedAt();

        // when
        task.deactivate();

        // then
        Assertions.assertEquals(id, task.getId());
        Assertions.assertEquals(category, task.getCategory());
        Assertions.assertEquals(createdAt, task.getCreatedAt());
        Assertions.assertNotEquals(active, task.isActive());
        Assertions.assertNotEquals(deletedAt, task.getDeletedAt());
        Assertions.assertEquals(title, task.getTitle());
        Assertions.assertEquals(frequency, task.getFrequency());
        Assertions.assertEquals(title, task.getTitle());
        Assertions.assertEquals(description, task.getDescription());
        Assertions.assertEquals(frequency, task.getFrequency());
        Assertions.assertTrue(task.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertNotNull(task.getDeletedAt());
    }

}
