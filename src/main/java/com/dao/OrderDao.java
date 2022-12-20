package com.dao;

import com.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAll();
    Order getById(int id);
    void save(Order order);
    void delete(int id);
}
