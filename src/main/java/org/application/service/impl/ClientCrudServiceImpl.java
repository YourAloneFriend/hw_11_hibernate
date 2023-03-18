package org.application.service.impl;

import org.application.entity.Client;
import org.application.entity.Ticket;
import org.application.hibernate.HibernateUtil;
import org.application.service.ClientCrudService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudServiceImpl implements ClientCrudService {
    @Override
    public void createClient(Client client) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    @Override
    public void updateClient(Client client) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client_get = session.get(Client.class, client.getId());
            client_get.setName(client.getName());
            transaction.commit();
        }
    }

    @Override
    public Client getClient(int id) {
        Client client;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            transaction.commit();
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients = session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
            transaction.commit();
        }
        return clients;
    }

    @Override
    public void removeClient(int id) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = new Client();
            client.setId(id);
            session.remove(client);
            transaction.commit();
        }
    }
}
