package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
    OrderLineEntity findById(int id);
}
