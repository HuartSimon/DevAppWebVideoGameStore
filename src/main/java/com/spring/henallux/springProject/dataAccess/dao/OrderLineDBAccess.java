package com.spring.henallux.springProject.dataAccess.dao;

import com.spring.henallux.springProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.springProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.springProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
