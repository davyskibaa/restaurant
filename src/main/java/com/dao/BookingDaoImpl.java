package com.dao;

import com.entity.Booking;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Booking> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Booking> query= session.createQuery("from Booking", Booking.class);
        return query.getResultList();
    }

    @Override
    public Booking getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Booking> query= session.createQuery("from Booking where id = :id", Booking.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Booking booking) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(booking);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Booking> query= session.createQuery("from Booking where id = :id", Booking.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
