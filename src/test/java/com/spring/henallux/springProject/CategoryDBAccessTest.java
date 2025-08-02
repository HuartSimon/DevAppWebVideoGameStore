package com.spring.henallux.springProject;

import com.spring.henallux.springProject.dataAccess.dao.CategoryDBAccess;
import com.spring.henallux.springProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.springProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CategoryDBAccessTest {

    private CategoryDBAccess categoryDBAccess;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProviderConverter providerConverter;

    @BeforeEach
    void setUp() {
        categoryDBAccess = new CategoryDBAccess(categoryRepository, providerConverter);
    }

    @Test
    public void findById_shouldReturnConvertedCategory() {
        // Arrange
        int categoryId = 1;
        CategoryEntity mockEntity = new CategoryEntity();
        Category mockCategory = new Category();

        when(categoryRepository.findById(categoryId)).thenReturn(mockEntity);
        when(providerConverter.categoryEntityToCategoryModel(mockEntity)).thenReturn(mockCategory);

        // Act
        Category result = categoryDBAccess.findById(categoryId);

        // Assert
        assertNotNull(result);
        assertThat(result).isEqualTo(mockCategory);
    }

    @Test
    void findAll_shouldReturnListOfConvertedCategories() {
        // Arrange
        CategoryEntity entity1 = new CategoryEntity();
        CategoryEntity entity2 = new CategoryEntity();
        ArrayList<CategoryEntity> mockEntities = new ArrayList<>();
        mockEntities.add(entity1);
        mockEntities.add(entity2);

        Category category1 = new Category(1);
        Category category2 = new Category(2);
        ArrayList<Category> expectedCategories = new ArrayList<>();
        expectedCategories.add(category1);
        expectedCategories.add(category2);


        when(categoryRepository.findAll()).thenReturn(mockEntities);
        when(providerConverter.categoryEntityToCategoryModel(entity1)).thenReturn(category1);
        when(providerConverter.categoryEntityToCategoryModel(entity2)).thenReturn(category2);

        // Act
        List<Category> result = categoryDBAccess.findAll();

        // Assert
        assertThat(result).isEqualTo(expectedCategories);
    }
}