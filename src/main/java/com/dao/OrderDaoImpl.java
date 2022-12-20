package com.dao;

import com.entity.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Order> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Order> query= session.createQuery("from Order", Order.class);
        return query.getResultList();
    }

    @Override
    public Order getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Order> query= session.createQuery("from Order where id = :id", Order.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(order);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Order> query= session.createQuery("from Order where id = :id", Order.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
