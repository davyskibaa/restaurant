package com.service;

import com.entity.Order;
import com.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    public List<Order> getAll() {
        return orderDao.getAll();
    }
    @Override
    @Transactional
    public Order getById(int id) {
        return orderDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    @Transactional
    public void delete(int id) {
        orderDao.delete(id);
    }
}
