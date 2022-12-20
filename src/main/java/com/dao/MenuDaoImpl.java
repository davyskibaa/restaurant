package com.dao;

import com.entity.Menu;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Menu> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Menu> query= session.createQuery("from Menu",Menu.class);
        return query.getResultList();
    }

    @Override
    public Menu getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Menu> query= session.createQuery("from Menu where id = :id",Menu.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Menu menu) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(menu);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Menu> query= session.createQuery("from Menu where id = :id",Menu.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
