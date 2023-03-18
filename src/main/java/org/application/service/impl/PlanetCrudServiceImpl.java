package org.application.service.impl;

import org.application.entity.Planet;
import org.application.hibernate.HibernateUtil;
import org.application.service.PlanetCrudService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudServiceImpl implements PlanetCrudService {

    @Override
    public void createPlanet(Planet planet) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    @Override
    public void updatePlanet(Planet planet) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet_get = session.get(Planet.class, planet.getId());
            planet_get.setName(planet.getName());
            transaction.commit();
        }
    }

    @Override
    public Planet getPlanet(String id) {
        Planet planet;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            planet = session.get(Planet.class, id);
            transaction.commit();
        }
        return planet;
    }

    @Override
    public List<Planet> getAllPlanets() {
        List<Planet> planets;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            planets = session.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
            transaction.commit();
        }
        return planets;
    }

    @Override
    public void removePlanet(String id) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = new Planet();
            planet.setId(id);
            session.remove(planet);
            transaction.commit();
        }
    }
}
