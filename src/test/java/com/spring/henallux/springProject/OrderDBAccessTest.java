package com.spring.henallux.springProject;
import com.spring.henallux.springProject.dataAccess.dao.OrderDBAccess;
import com.spring.henallux.springProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.springProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.springProject.dataAccess.entity.UserEntity;
import com.spring.henallux.springProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class OrderDBAccessTest {
    private OrderDBAccess orderDBAccess;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderDBAccess = new OrderDBAccess(orderRepository, new ProviderConverter());
    }

    @Test
    void testFindById() {
        // Arrange
        OrderEntity mockedOrderEntity = new OrderEntity(new UserEntity("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true), new ArrayList<>());
        Order expectedOrder = new Order(new User("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true), new ArrayList<>());

        when(orderRepository.findById(1)).thenReturn(mockedOrderEntity);

        // Act
        Order result = orderDBAccess.findById(1);

        // Assert
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedOrder);
    }

    @Test
    void testFindAll() {
        // Arrange
        OrderEntity entity1 = new OrderEntity(new UserEntity("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true), new ArrayList<>());
        OrderEntity entity2 = new OrderEntity(new UserEntity("user2", "user2", "user2", "user2@gmail.com", "rue du user2", "user123", "0499848929", false), new ArrayList<>());
        ArrayList<OrderEntity> mockedOrderEntities = new ArrayList<>();
        mockedOrderEntities.add(entity1);
        mockedOrderEntities.add(entity2);

        Order order1 = new Order(new User("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true), new ArrayList<>());
        Order order2 = new Order(new User("user2", "user2", "user2", "user2@gmail.com", "rue du user2", "user123", "0499848929", false), new ArrayList<>());
        ArrayList<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order1);
        expectedOrders.add(order2);

        when(orderRepository.findAll()).thenReturn(mockedOrderEntities);

        // Act
        List<Order> result = orderDBAccess.findAll();

        // Assert
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedOrders);
    }

    @Test
    void testFindByUser() {
        // Arrange
        User user = new User("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true);
        UserEntity userEntity = new UserEntity("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true);

        OrderEntity entity1 = new OrderEntity(userEntity, new ArrayList<>());
        OrderEntity entity2 = new OrderEntity(userEntity, new ArrayList<>());
        ArrayList<OrderEntity> mockedOrderEntities = new ArrayList<>();
        mockedOrderEntities.add(entity1);
        mockedOrderEntities.add(entity2);

        Order order1 = new Order(user, new ArrayList<>());
        Order order2 = new Order(user, new ArrayList<>());
        ArrayList<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order1);
        expectedOrders.add(order2);

        when(orderRepository.findByUser(any(UserEntity.class))).thenReturn(mockedOrderEntities);

        // Act
        ArrayList<Order> result = orderDBAccess.findByUser(user);

        // Assert
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedOrders);
    }
}
