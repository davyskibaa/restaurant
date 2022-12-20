package com.dao;

import com.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> getAll() {
        Session session= entityManager.unwrap(Session.class);
        Query<Client> query= session.createQuery("from Client", Client.class);
        return query.getResultList();
    }

    @Override
    public Client getById(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Client> query= session.createQuery("from Client where id = :id", Client.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Client client) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(client);
    }

    @Override
    public void delete(int id) {
        Session session= entityManager.unwrap(Session.class);
        Query<Client> query= session.createQuery("from Client where id = :id", Client.class);
        query.setParameter("id",id);
        session.delete(query.getSingleResult());
    }
}
