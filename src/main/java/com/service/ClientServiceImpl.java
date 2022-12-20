package com.service;

import com.dao.ClientDao;
import com.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;

    @Override
    @Transactional
    public List<Client> getAll() {
        return clientDao.getAll();
    }
    @Override
    @Transactional
    public Client getById(int id) {
        return clientDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional
    public void delete(int id) {
        clientDao.delete(id);
    }
}
