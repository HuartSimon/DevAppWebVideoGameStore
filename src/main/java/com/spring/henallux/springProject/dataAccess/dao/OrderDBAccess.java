package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.springProject.dataAccess.entity.UserEntity;
import com.spring.henallux.springProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.Order;
import com.spring.henallux.springProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

;


@Service
public class OrderDBAccess implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDBAccess(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }
    @Override
    public Order findById(int id) {
        return providerConverter.orderEntityToOrderModel(orderRepository.findById(id));
    }

    @Override
    public ArrayList<Order> findAll() {
         List<OrderEntity> ordersEntities = orderRepository.findAll();
         ArrayList<Order> ordersModel = new ArrayList<>();
         for (OrderEntity orderEntity : ordersEntities) {
             ordersModel.add(providerConverter.orderEntityToOrderModel(orderEntity));
         }
         return ordersModel;
    }

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        return providerConverter.orderEntityToOrderModel(orderRepository.save(orderEntity));
    }

    @Override
    public ArrayList<Order> findByUser(User user) {
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        List<OrderEntity> ordersEntities = orderRepository.findByUser(userEntity);

        ArrayList<Order> ordersModel = new ArrayList<>();
        for (OrderEntity orderEntity : ordersEntities) {
            ordersModel.add(providerConverter.orderEntityToOrderModel(orderEntity));
        }
        return ordersModel;
    }
}
