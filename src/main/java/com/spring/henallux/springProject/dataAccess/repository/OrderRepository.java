package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findById(int id);
}
