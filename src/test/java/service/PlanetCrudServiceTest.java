package service;

import org.application.entity.Planet;
import org.application.service.PlanetCrudService;
import org.application.service.impl.PlanetCrudServiceImpl;
import org.junit.jupiter.api.*;

import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlanetCrudServiceTest {

    private static PlanetCrudService service;

    @BeforeAll
    static void setUp(){
        service = new PlanetCrudServiceImpl();
    }

    @Test
    @Order(1)
    void testCreatePlanet(){
        Planet planet = new Planet();
        planet.setId("KOI-4742.01");
        planet.setName("Kepler-442 b");
        service.createPlanet(planet);
    }

    @Test
    @Order(2)
    void testUpdatePlanet(){
        Planet planet = new Planet();
        planet.setId("KOI-4742.01");
        planet.setName("Kepler-442 B");
        service.updatePlanet(planet);
    }

    @Test
    @Order(3)
    void testGetPlanet(){
        Planet planet = service.getPlanet("KOI-4742.01");
        Assertions.assertEquals("Kepler-442 B", planet.getName());
    }

    @Test
    @Order(4)
    void testGetAllPlanets(){
        List<Planet> planets = service.getAllPlanets();
        Assertions.assertEquals(6, planets.size());
    }

    @Test
    @Order(5)
    void testRemovePlanet(){
        service.removePlanet("KOI-4742.01");
        Planet planet = service.getPlanet("KOI-4742.01");
        Assertions.assertNull(planet);
    }
}
