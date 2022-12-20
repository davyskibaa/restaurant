package com.service;

import com.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getById(int id);
    void save(Order order);
    void delete(int id);
}
