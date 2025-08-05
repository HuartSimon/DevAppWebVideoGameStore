package com.spring.henallux.springProject;

import com.spring.henallux.springProject.model.Category;
import com.spring.henallux.springProject.model.Discount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CategoryTest {

    @Test
    public void testGetCurrentDiscountValue(){
        // Arrange
        List<Discount> discounts = new ArrayList<Discount>();
        var expectedDiscountVal = 0.1;

        discounts.add(new Discount(1, expectedDiscountVal, LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(5)));
        discounts.add(new Discount(1, 0.5, LocalDateTime.now().plusDays(7), LocalDateTime.now().plusDays(15)));
        Category category = new Category(1, discounts);

        // Act
        var discountVal = category.getCurrentDiscountValue();

        // Assert
        assertThat(discountVal).isEqualTo(expectedDiscountVal);
    }
}
