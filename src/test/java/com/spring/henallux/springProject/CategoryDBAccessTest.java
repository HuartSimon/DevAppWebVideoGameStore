package com.spring.henallux.springProject;

import com.spring.henallux.springProject.dataAccess.dao.CategoryDBAccess;
import com.spring.henallux.springProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CategoryDBAccessTest {

    private CategoryDBAccess categoryDBAccess;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryDBAccess = new CategoryDBAccess(categoryRepository, new ProviderConverter());
    }

    @Test
    public void findById_shouldReturnConvertedCategory() {
        // Arrange
        int categoryId = 1;
        CategoryEntity mockedCategoryEntity = new CategoryEntity(categoryId, new ArrayList<>());
        Category expectedCategory = new Category(categoryId, new ArrayList<>());

        when(categoryRepository.findById(categoryId)).thenReturn(mockedCategoryEntity);

        // Act
        Category result = categoryDBAccess.findById(categoryId);

        // Assert
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedCategory);
    }

    @Test
    void findAll_shouldReturnListOfConvertedCategories() {
        // Arrange
        CategoryEntity entity1 = new CategoryEntity(1, new ArrayList<>());
        CategoryEntity entity2 = new CategoryEntity(2, new ArrayList<>());
        ArrayList<CategoryEntity> mockedEntities = new ArrayList<>();
        mockedEntities.add(entity1);
        mockedEntities.add(entity2);

        Category category1 = new Category(1, new ArrayList<>());
        Category category2 = new Category(2, new ArrayList<>());
        ArrayList<Category> expectedCategories = new ArrayList<>();
        expectedCategories.add(category1);
        expectedCategories.add(category2);

        when(categoryRepository.findAll()).thenReturn(mockedEntities);

        // Act
        List<Category> result = categoryDBAccess.findAll();

        // Assert
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedCategories);
    }
}