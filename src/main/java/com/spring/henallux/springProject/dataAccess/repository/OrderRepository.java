package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.springProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findById(int id);
    OrderEntity save(OrderEntity order);
    ArrayList<OrderEntity> findByUser(UserEntity user);
}
