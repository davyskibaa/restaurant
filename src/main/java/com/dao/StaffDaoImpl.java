package com.dao;

import com.entity.Staff;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StaffDaoImpl implements StaffDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Staff> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Staff> query= session.createQuery("from Staff", Staff.class);
        return query.getResultList();
    }

    @Override
    public Staff getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Staff> query= session.createQuery("from Staff where id = :id", Staff.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Staff staff) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(staff);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Staff> query= session.createQuery("from Staff where id = :id", Staff.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
