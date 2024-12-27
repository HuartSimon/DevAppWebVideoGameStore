package com.spring.henallux.springProject.controller;

import com.spring.henallux.springProject.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orderLine")
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    // Supprimer une ligne de commande
    @DeleteMapping("/{orderLineId}")
    public ResponseEntity<String> deleteOrderLine(@PathVariable Integer orderLineId) {
        try {
            orderLineService.deleteOrderLine(orderLineId);
            return ResponseEntity.ok("Order line deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting order line.");
        }
    }

    // Ajouter un article
    @PostMapping("/{orderLineId}/add")
    public ResponseEntity<String> addItem(@PathVariable Integer orderLineId) {
        try {
            orderLineService.addItem(orderLineId);
            return ResponseEntity.ok("Item added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding item.");
        }
    }

    // Enlever un article
    @PostMapping("/{orderLineId}/remove")
    public ResponseEntity<String> removeItem(@PathVariable Integer orderLineId) {
        try {
            orderLineService.removeItem(orderLineId);
            return ResponseEntity.ok("Item removed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing item.");
        }
    }
}

