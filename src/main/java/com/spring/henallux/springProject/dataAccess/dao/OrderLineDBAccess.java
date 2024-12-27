package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.springProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineDBAccess implements OrderLineDataAccess{

    private OrderLineRepository orderLineRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderLineDBAccess(OrderLineRepository orderLineRepository, ProviderConverter providerConverter) {
        this.orderLineRepository = orderLineRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public OrderLine findById(int id) {
        return providerConverter.orderLineEntityToOrderLineModel(orderLineRepository.findById(id));
    }

    @Override
    public ArrayList<OrderLine> findAll() {
        return new ArrayList<>(orderLineRepository.findAll()
                .stream()
                .map(orderLineEntity -> providerConverter.orderLineEntityToOrderLineModel(orderLineEntity))
                .toList());
    }

    @Override
    public OrderLine saveOrderLine(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = orderLineRepository.save(providerConverter.orderLineModelToOrderLineEntity(orderLine));
        return providerConverter.orderLineEntityToOrderLineModel(orderLineEntity);
    }

    @Override
    public void deleteOrderLineById(int id) {
        OrderLineEntity orderLineEntity = orderLineRepository.findById(id);
        orderLineRepository.delete(orderLineEntity);
    }

    @Override
    public ArrayList<OrderLine> findByOrderId(int orderId) {
        ArrayList<OrderLineEntity> orderLinesEntities = orderLineRepository.findByOrderId(orderId);
        ArrayList<OrderLine> orderLinesModels = new ArrayList<>();
        for (OrderLineEntity orderLineEntity : orderLinesEntities) {
            orderLinesModels.add(providerConverter.orderLineEntityToOrderLineModel(orderLineEntity));
        }
        return orderLinesModels;
    }


}
