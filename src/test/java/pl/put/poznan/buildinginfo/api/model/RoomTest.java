package pl.put.poznan.buildinginfo.api.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {
    private Room room;

    @Before
    public void setUp() {
        room = new Room();
        room.setId("R001");
        room.setName("Conference Room");
        room.setArea(50.0);
        room.setCube(150.0);
        room.setLight(300.0);
        room.setHeating(500.0);
        room.setWater(200.0);
    }

    @Test
    public void testRoomId() {
        assertEquals("R001", room.getId());
    }

    @Test
    public void testRoomName() {
        assertEquals("Conference Room", room.getName());
    }

    @Test
    public void testRoomArea() {
        assertEquals(50.0, room.getArea(), 0.0);
    }

    @Test
    public void testRoomCube() {
        assertEquals(150.0, room.getCube(), 0.0);
    }

    @Test
    public void testRoomLight() {
        assertEquals(300.0, room.getLight(), 0.0);
    }

    @Test
    public void testRoomHeating() {
        assertEquals(500.0, room.getHeating(), 0.0);
    }

    @Test
    public void testRoomWater() {
        assertEquals(200.0, room.getWater(), 0.0);
    }

    @Test
    public void testCalculateArea() {
        double expectedArea = 50.0;
        assertEquals(expectedArea, room.calculateArea(), 0.0);
    }

    @Test
    public void testCalculateVolume() {
        double expectedVolume = 150.0;
        assertEquals(expectedVolume, room.calculateVolume(), 0.0);
    }

    @Test
    public void testCalculateLightingPower() {
        double expectedLightingPower = 300.0;
        assertEquals(expectedLightingPower, room.calculateLightingPower(), 0.0);
    }

    @Test
    public void testCalculateHeatingEnergy() {
        double expectedHeatingEnergy = 500.0;
        assertEquals(expectedHeatingEnergy, room.calculateHeatingEnergy(), 0.0);
    }

    @Test
    public void testCalculateWaterConsumptionPerUnitVolume() {
        double expectedWaterConsumptionPerUnitVolume = 200.0 / 150.0;
        assertEquals(expectedWaterConsumptionPerUnitVolume, room.calculateWaterConsumptionPerUnitVolume(), 0.0001);
    }
}
