package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
    OrderLineEntity findById(int id);
    OrderLineEntity save(OrderLineEntity orderLine);
    OrderLineEntity deleteById(int id);
    ArrayList<OrderLineEntity> findByOrderId(int orderId);
}
