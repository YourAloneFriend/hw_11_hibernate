package org.application.service;

import org.application.entity.Planet;

import java.util.List;

public interface PlanetCrudService {

    void createPlanet(Planet planet);

    void updatePlanet(Planet planet);

    Planet getPlanet(String id);

    public List<Planet> getAllPlanets();

    void removePlanet(String id);
}
