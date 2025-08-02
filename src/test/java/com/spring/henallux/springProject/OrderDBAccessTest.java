package com.spring.henallux.springProject;
import com.spring.henallux.springProject.dataAccess.dao.OrderDBAccess;
import com.spring.henallux.springProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.springProject.dataAccess.entity.UserEntity;
import com.spring.henallux.springProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class OrderDBAccessTest {
    private OrderDBAccess orderDBAccess;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProviderConverter providerConverter;

    @BeforeEach
    void setUp() {
        orderDBAccess = new OrderDBAccess(orderRepository, providerConverter);
    }

    @Test
    void testFindById() {
        // Arrange
        OrderEntity mockEntity = new OrderEntity();
        Order expectedOrder = new Order(new User("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true));

        when(orderRepository.findById(1)).thenReturn(mockEntity);
        when(providerConverter.orderEntityToOrderModel(mockEntity)).thenReturn(expectedOrder);

        // Act
        Order result = orderDBAccess.findById(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedOrder, result);
    }

    @Test
    void testFindAll() {
        // Arrange
        OrderEntity entity1 = new OrderEntity();
        OrderEntity entity2 = new OrderEntity();
        ArrayList<OrderEntity> mockEntities = new ArrayList<>();
        mockEntities.add(entity1);
        mockEntities.add(entity2);

        Order order1 = new Order(new User("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true));
        Order order2 = new Order(new User("user2", "user2", "user2", "user2@gmail.com", "rue du user2", "user123", "0499848929", false));
        ArrayList<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order1);
        expectedOrders.add(order2);


        when(orderRepository.findAll()).thenReturn(mockEntities);
        when(providerConverter.orderEntityToOrderModel(entity1)).thenReturn(order1);
        when(providerConverter.orderEntityToOrderModel(entity2)).thenReturn(order2);

        // Act
        List<Order> result = orderDBAccess.findAll();

        // Assert
        assertThat(result).isEqualTo(expectedOrders);
    }

//    @Test
//    void testSaveOrder() {
//        //A FAIRE
//    }

    @Test
    void testFindByUser() {
        // Arrange
        User user = new User("user1", "user1", "user1", "user1@gmail.com", "rue du user1", "User123", "0472714987", true);
        UserEntity userEntity = new UserEntity();

        OrderEntity entity1 = new OrderEntity();
        OrderEntity entity2 = new OrderEntity();
        ArrayList<OrderEntity> mockEntities = new ArrayList<>();
        mockEntities.add(entity1);
        mockEntities.add(entity2);

        Order order1 = new Order(user);
        Order order2 = new Order(user);
        ArrayList<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order1);
        expectedOrders.add(order2);

        when(providerConverter.userModelToUserEntity(user)).thenReturn(userEntity);
        when(orderRepository.findByUser(userEntity)).thenReturn(mockEntities);
        when(providerConverter.orderEntityToOrderModel(entity1)).thenReturn(order1);
        when(providerConverter.orderEntityToOrderModel(entity2)).thenReturn(order2);

        ArrayList<Order> result = orderDBAccess.findByUser(user);

        assertEquals(2, result.size());
        assertEquals(result.get(0).getUser(), user);
        assertEquals(result.get(1).getUser(), user);
        assertEquals(order1, result.get(0));
        assertEquals(order2, result.get(1));
    }
}
