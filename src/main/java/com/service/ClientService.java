package com.service;

import com.entity.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client getById(int id);
    void save(Client client);
    void delete(int id);
}
