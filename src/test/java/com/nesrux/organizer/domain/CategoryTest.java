package com.nesrux.organizer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nesrux.organizer.MockDomain;
import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.domain.exceptions.DomainException;

public class CategoryTest {

    @Test
    public void givenAvalidParams_whenCallsCreateCategory_thenInstantiateACategory() {
        // given
        final var aName = "academia";

        // when
        final var category = Category.create(aName);

        // them
        Assertions.assertEquals(aName, category.getName());
        Assertions.assertNotNull(category.getId());
        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getUpdatedAt());

    }

    @Test
    public void givenANullName_whenCallsCreateCategory_themThrowException() {
        // given
        final var aMessage = "name not be null";
        final String aName = null;

        // when
        final var actualException = Assertions.assertThrows(DomainException.class, () -> {
            Category.create(aName);
        });

        // then
        Assertions.assertEquals(aMessage, actualException.getMessage());

    }

    @Test
    public void givenAnEmptyName_whenCallsCreateCategory_themThrowException() {
        // given
        final var aMessage = "name not be empty";
        final String aName = "";

        // when
        final var actualException = Assertions.assertThrows(DomainException.class, () -> {
            Category.create(aName);
        });

        // then
        Assertions.assertEquals(aMessage, actualException.getMessage());

    }

    @Test
    public void givenANameWithInvalidLenth_whenCallsCreateCategory_themThrowException() {
        // given
        final var aMessage = "name must have at least 4 characters";
        final String aName = "aaa";

        // when
        final var actualException = Assertions.assertThrows(DomainException.class, () -> {
            Category.create(aName);
        });

        // then
        Assertions.assertEquals(aMessage, actualException.getMessage());

    }

    @Test
    public void givenAvalidCategory_whenCallsAddTask_thenReturnAcategory() {
        // given
        final var aCategory = MockDomain.categoryMock();
        final var name = aCategory.getName();
        final var id = aCategory.getId();
        final var createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdatedAt();
        final var task = Task.create("Limpeza de estudos", "limpar toda a bancade de estudos", Frequency.UNIQUE,
                aCategory);

        // when
        aCategory.addTask(task);

        // then
        Assertions.assertEquals(name, aCategory.getName());
        Assertions.assertEquals(id, aCategory.getId());
        Assertions.assertEquals(createdAt, aCategory.getCreatedAt());
        Assertions.assertTrue(aCategory.getUpdatedAt().isAfter(updatedAt));
    }

    @Test
    public void givenAvalidCategory_whenCallsDeleteTask_thenReturnAcategory() {
        // given
        final var aCategory = MockDomain.categoryMock();
        final var name = aCategory.getName();
        final var id = aCategory.getId();
        final var createdAt = aCategory.getCreatedAt();
        final var updatedAt = aCategory.getUpdatedAt();
        final var task = Task.create("Limpeza de estudos", "limpar toda a bancade de estudos", Frequency.UNIQUE,
                aCategory);
        aCategory.addTask(task);
        aCategory.addTask(MockDomain.taskMock());

        // when
        aCategory.deleteTask(task);

        // then
        Assertions.assertEquals(name, aCategory.getName());
        Assertions.assertEquals(id, aCategory.getId());
        Assertions.assertEquals(createdAt, aCategory.getCreatedAt());
        Assertions.assertTrue(aCategory.getUpdatedAt().isAfter(updatedAt));
        Assertions.assertFalse(aCategory.getTasks().contains(task));
    }

}
