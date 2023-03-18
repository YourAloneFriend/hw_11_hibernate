package org.application.service;

import org.application.entity.Client;
import org.application.entity.Ticket;

import java.util.List;

public interface ClientCrudService {

    void createClient(Client client);

    void updateClient(Client client);

    Client getClient(int id);

    List<Client> getAllClients();

    void removeClient(int id);



}
