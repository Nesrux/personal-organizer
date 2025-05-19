package com.nesrux.organizer.domain;

import com.nesrux.organizer.domain.utils.IdUtils;
import com.nesrux.organizer.domain.utils.InstantUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nesrux.organizer.MockDomain;
import com.nesrux.organizer.domain.models.category.Category;
import com.nesrux.organizer.domain.models.task.Frequency;
import com.nesrux.organizer.domain.models.task.Task;
import com.nesrux.organizer.domain.exceptions.DomainException;
import org.springframework.util.Assert;

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
    public void givenAValidParams_whenCallsWith_thenReturnNewCategory() {
        //given
        final var name = "estudos";
        final var id = IdUtils.uuid();
        final var createdAt = InstantUtils.now();
        final var updatedAt = InstantUtils.now();

        //whem
        final var actualCategory = Category.with(id, name, createdAt, updatedAt);

        //them
        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(id, actualCategory.getId());
        Assertions.assertEquals(name, actualCategory.getName());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        Assertions.assertEquals(updatedAt, actualCategory.getUpdatedAt());

    }

    @Test
    public void givenANullId_whenCallsWith_thenThrowException() {
        //given
        final var name = "estudos";
        final String id = null;
        final var createdAt = InstantUtils.now();
        final var updatedAt = InstantUtils.now();
        final var expectedMessage = "id not be null";

        //whem
        final var actualException = Assertions.assertThrows(NullPointerException.class, () -> Category.with(id, name, createdAt, updatedAt));

        //them
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
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
    public void givenAValidCategory_whenCallsUpdate_themUpdateACategory() {
        //given
        final var category = MockDomain.categoryMock();
        final var id = category.getId();
        final var name = category.getName();
        final var createdAt = category.getCreatedAt();
        final var updatedAt = category.getUpdatedAt();
        final var expectedName = "Estudos";
        //when
        final var actualCategory = category.update(expectedName);

        //then
        Assertions.assertEquals(id, actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(createdAt, actualCategory.getCreatedAt());
        Assertions.assertTrue(updatedAt.isBefore(actualCategory.getUpdatedAt()));
        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());


    }

    @Test
    public void givenANullName_whenCallsUpdate_thenThowException() {
        //given
        final var category = MockDomain.categoryMock();
        final var name = category.getName();
        final String expectedName = null;
        final var expectedMessage = "name not be null";
        //when
        final var actualException = Assertions.assertThrows(DomainException.class, () -> category.update(expectedName));

        //then
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
        Assertions.assertEquals(name, category.getName());

    }

    @Test
    public void givenAnEmptyName_whenCallsUpdate_thenThowException() {
        //given
        final var category = MockDomain.categoryMock();
        final var name = category.getName();
        final String expectedName = "";
        final var expectedMessage = "name not be empty";
        //when
        final var actualException = Assertions.assertThrows(DomainException.class, () -> category.update(expectedName));

        //then
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
        Assertions.assertEquals(name, category.getName());

    }

}
