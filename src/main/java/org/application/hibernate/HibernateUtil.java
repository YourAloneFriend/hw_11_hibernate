package org.application.hibernate;

import lombok.Getter;
import org.application.entity.Client;
import org.application.entity.Planet;
import org.application.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final HibernateUtil INSTANCE = new HibernateUtil();

    @Getter
    private SessionFactory sessionFactory;

    private HibernateUtil(){
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class).buildSessionFactory();
    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }

    @Override
    protected void finalize() {
        sessionFactory.close();
    }
}
