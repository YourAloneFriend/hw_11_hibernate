package org.application.service.impl;

import org.application.entity.Ticket;
import org.application.hibernate.HibernateUtil;
import org.application.service.TicketCrudService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class TicketCrudServiceImpl implements TicketCrudService {
    @Override
    public void createTicket(Ticket ticket) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    @Override
    public void updateTicket(Ticket ticket) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket_get = session.get(Ticket.class, ticket.getId());

            if(ticket.getToPlanetId() != null)
                ticket_get.setToPlanetId(ticket.getToPlanetId());

            if(ticket.getFromPlanetId() != null)
                ticket_get.setFromPlanetId(ticket.getFromPlanetId());

            ticket_get.setCreatedAt(LocalDateTime.now());

            transaction.commit();
        }
    }

    @Override
    public Ticket getTicket(int id) {
        Ticket ticket;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            ticket = session.get(Ticket.class, id);
            transaction.commit();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            tickets = session.createQuery("SELECT c FROM Ticket c", Ticket.class).getResultList();
            transaction.commit();
        }
        return tickets;
    }

    @Override
    public void removeTicket(int id) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = new Ticket();
            ticket.setId(id);
            session.remove(ticket);
            transaction.commit();
        }
    }
}
