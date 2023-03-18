package service;

import org.application.entity.Client;
import org.application.entity.Ticket;
import org.application.service.ClientCrudService;
import org.application.service.TicketCrudService;
import org.application.service.impl.ClientCrudServiceImpl;
import org.application.service.impl.TicketCrudServiceImpl;
import org.junit.jupiter.api.*;

import javax.persistence.PersistenceException;
import java.time.LocalDateTime;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TicketCrudServiceTest {

    private static TicketCrudService service;
    private static ClientCrudService clientService;

    @BeforeAll
    static void setUp(){
        service = new TicketCrudServiceImpl();
        clientService = new ClientCrudServiceImpl();
    }

    @Test
    @Order(1)
    void testCreateTicket(){
        Client client = clientService.getClient(1);
        Ticket ticket = new Ticket();
        ticket.setId(11);
        ticket.setClient(client);
        ticket.setToPlanetId("EU");
        ticket.setFromPlanetId("MN");
        ticket.setCreatedAt(LocalDateTime.now());
        service.createTicket(ticket);
    }

    @Test
    @Order(2)
    void testCreateTicketWithNullUser(){
        Ticket ticket = new Ticket();
        ticket.setId(12);
        ticket.setClient(null);
        ticket.setToPlanetId("EU");
        ticket.setFromPlanetId("MN");
        ticket.setCreatedAt(LocalDateTime.now());
        Assertions.assertThrows(PersistenceException.class, () -> {service.createTicket(ticket);});
    }

    @Test
    @Order(3)
    void testCreateTicketWithNotExistingPlanet(){
        Client client = clientService.getClient(1);
        Ticket ticket = new Ticket();
        ticket.setId(12);
        ticket.setClient(client);
        ticket.setToPlanetId("EU");
        ticket.setFromPlanetId("MNNN");
        ticket.setCreatedAt(LocalDateTime.now());
        Assertions.assertThrows(PersistenceException.class, () -> {service.createTicket(ticket);});
    }

    @Test
    @Order(4)
    void testUpdateTicket(){
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setToPlanetId("KOI-1361.01");
        service.updateTicket(ticket);
    }

    @Test
    @Order(5)
    void testGetTicket(){
        Ticket ticket = service.getTicket(1);
        Assertions.assertNotNull(ticket);
    }

    @Test
    @Order(6)
    void testGetAllTickets(){
        List<Ticket> tickets = service.getAllTickets();
        Assertions.assertEquals(11, tickets.size());
    }

    @Test
    @Order(7)
    void testRemoveTicket(){
        service.removeTicket(11);
        Ticket ticket = service.getTicket(11);
        Assertions.assertNull(ticket);
    }
}
