package com.spring.henallux.springProject.dataAccess.repository;

import com.spring.henallux.springProject.dataAccess.entity.DiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
    DiscountEntity findById(int Id);
    ArrayList<DiscountEntity> findDiscountEntitiesByBeginDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime beginDate, LocalDateTime endDate);
    DiscountEntity findDiscountEntityByBeginDateLessThanEqualAndEndDateGreaterThanEqualAndCategory_Id(LocalDateTime beginDate, LocalDateTime endDate, Integer id);
}
