package pl.put.poznan.buildinginfo.api.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;

public class BuildingTest {
    private Building building;
    private Level level1;
    private Level level2;

    @Before
    public void setUp() {
        building = new Building();
        level1 = new Level();
        level2 = new Level();

        // Mocking Room setup to simplify the example
        Room room1 = new Room();
        Room room2 = new Room();
        room1.setArea(100.0);
        room1.setCube(300.0);
        room1.setLight(500.0);
        room1.setHeating(600.0);
        room1.setWater(150.0);
        room2.setArea(200.0);
        room2.setCube(400.0);
        room2.setLight(600.0);
        room2.setHeating(700.0);
        room2.setWater(250.0);

        // Setting up levels with rooms
        level1.setRooms(new ArrayList<>(Arrays.asList(room1)));
        level2.setRooms(new ArrayList<>(Arrays.asList(room2)));

        building.setId("B001");
        building.setName("Main Building");
        building.setLevels(Arrays.asList(level1, level2));
    }

    @Test
    public void testBuildingId() {
        assertEquals("B001", building.getId());
    }

    @Test
    public void testBuildingName() {
        assertEquals("Main Building", building.getName());
    }

    @Test
    public void testGetLevels() {
        assertEquals(Arrays.asList(level1, level2), building.getLevels());
    }

    @Test
    public void testCalculateTotalArea() {
        double expectedArea = 100.0 + 200.0; // Sum of areas from level1 and level2
        assertEquals(expectedArea, building.calculateArea(), 0.0);
    }

    @Test
    public void testCalculateTotalVolume() {
        double expectedVolume = 300.0 + 400.0; // Sum of volumes from level1 and level2
        assertEquals(expectedVolume, building.calculateVolume(), 0.0);
    }

    @Test
    public void testCalculateTotalLightingPower() {
        double expectedLightingPower = 500.0 + 600.0; // Sum of lighting power from level1 and level2
        assertEquals(expectedLightingPower, building.calculateLightingPower(), 0.0);
    }

    @Test
    public void testCalculateTotalHeatingEnergy() {
        double expectedHeatingEnergy = 600.0 + 700.0; // Sum of heating energy from level1 and level2
        assertEquals(expectedHeatingEnergy, building.calculateHeatingEnergy(), 0.0);
    }

    @Test
    public void testCalculateTotalWaterConsumption() {
        double expectedWaterConsumption = 150.0 + 250.0; // Sum of water consumption from level1 and level2
        assertEquals(expectedWaterConsumption, building.calculateWaterConsumption(), 0.0);
    }

    @Test
    public void testCalculateWaterConsumptionPerUnitVolume() {
        double expectedWaterPerUnitVolume = (150.0 + 250.0) / (300.0 + 400.0);
        assertEquals(expectedWaterPerUnitVolume, building.calculateWaterConsumptionPerUnitVolume(), 0.0001);
    }
}
