package pl.put.poznan.buildinginfo.api.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class LevelTest {
    private Level level;
    private Room room1;
    private Room room2;

    @Before
    public void setUp() {
        level = new Level();
        room1 = new Room();
        room2 = new Room();

        room1.setArea(100.0);
        room1.setCube(250.0);
        room1.setLight(200.0);
        room1.setHeating(400.0);
        room1.setWater(300.0);

        room2.setArea(150.0);
        room2.setCube(350.0);
        room2.setLight(250.0);
        room2.setHeating(450.0);
        room2.setWater(350.0);

        level.setId("L001");
        level.setName("First Floor");
        level.setRooms(Arrays.asList(room1, room2));
    }

    @Test
    public void testLevelId() {
        assertEquals("L001", level.getId());
    }

    @Test
    public void testLevelName() {
        assertEquals("First Floor", level.getName());
    }

    @Test
    public void testGetRooms() {
        assertEquals(Arrays.asList(room1, room2), level.getRooms());
    }

    @Test
    public void testCalculateTotalArea() {
        double expectedArea = 100.0 + 150.0;
        assertEquals(expectedArea, level.calculateArea(), 0.0);
    }

    @Test
    public void testCalculateTotalVolume() {
        double expectedVolume = 250.0 + 350.0;
        assertEquals(expectedVolume, level.calculateVolume(), 0.0);
    }

    @Test
    public void testCalculateTotalLightingPower() {
        double expectedLightingPower = 200.0 + 250.0;
        assertEquals(expectedLightingPower, level.calculateLightingPower(), 0.0);
    }

    @Test
    public void testCalculateTotalHeatingEnergy() {
        double expectedHeatingEnergy = 400.0 + 450.0;
        assertEquals(expectedHeatingEnergy, level.calculateHeatingEnergy(), 0.0);
    }

    @Test
    public void testCalculateTotalWaterConsumption() {
        double expectedWaterConsumption = 300.0 + 350.0;
        assertEquals(expectedWaterConsumption, level.calculateWaterConsumption(), 0.0);
    }

    @Test
    public void testCalculateWaterConsumptionPerUnitVolume() {
        double expectedWaterPerUnitVolume = (300.0 + 350.0) / (250.0 + 350.0);
        assertEquals(expectedWaterPerUnitVolume, level.calculateWaterConsumptionPerUnitVolume(), 0.0001);
    }
}
