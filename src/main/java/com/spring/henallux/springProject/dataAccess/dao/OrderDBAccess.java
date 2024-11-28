package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.springProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.henallux.springProject.model.Order;

import java.util.ArrayList;
import java.util.List;


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

}
