package org.application.service;

import org.application.entity.Ticket;

import java.util.List;

public interface TicketCrudService {

    void createTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    Ticket getTicket(int id);

    List<Ticket> getAllTickets();


    void removeTicket(int id);
}
