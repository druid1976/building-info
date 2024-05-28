package pl.put.poznan.buildinginfo.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BuildingTest {

    private Building building;

    @BeforeEach
    void setUp() {
        building = new Building();
    }

    @Test
    void testSetId() {
        building.setId("B001");
        assertEquals("B001", building.getId());
    }

    @Test
    void testGetId() {
        building.setId("B002");
        String id = building.getId();
        assertEquals("B002", id);
    }

    @Test
    void testSetName() {
        building.setName("Main Building");
        assertEquals("Main Building", building.getName());
    }

    @Test
    void testGetName() {
        building.setName("Secondary Building");
        String name = building.getName();
        assertEquals("Secondary Building", name);
    }

    @Test
    void testSetLevels() {
        Level level1 = new Level();
        Level level2 = new Level();
        List<Level> levels = Arrays.asList(level1, level2);
        building.setLevels(levels);
        assertEquals(levels, building.getLevels());
    }

    @Test
    void testGetLevels() {
        Level level1 = new Level();
        Level level2 = new Level();
        List<Level> levels = Arrays.asList(level1, level2);
        building.setLevels(levels);
        List<Level> retrievedLevels = building.getLevels();
        assertEquals(levels, retrievedLevels);
    }

    @Test
    void testCalculateArea() {
        Room room1 = new Room();
        room1.setArea(50.0);
        Room room2 = new Room();
        room2.setArea(50.0);

        Level level1 = new Level();
        level1.setRooms(Arrays.asList(room1, room2));

        Room room3 = new Room();
        room3.setArea(100.0);
        Room room4 = new Room();
        room4.setArea(100.0);

        Level level2 = new Level();
        level2.setRooms(Arrays.asList(room3, room4));

        building.setLevels(Arrays.asList(level1, level2));
        double totalArea = building.calculateArea();

        assertEquals(300.0, totalArea);
    }

    @Test
    void testCalculateVolume() {
        Room room1 = new Room();
        room1.setCube(150.0);
        Room room2 = new Room();
        room2.setCube(150.0);

        Level level1 = new Level();
        level1.setRooms(Arrays.asList(room1, room2));

        Room room3 = new Room();
        room3.setCube(300.0);
        Room room4 = new Room();
        room4.setCube(300.0);

        Level level2 = new Level();
        level2.setRooms(Arrays.asList(room3, room4));

        building.setLevels(Arrays.asList(level1, level2));
        double totalVolume = building.calculateVolume();

        assertEquals(900.0, totalVolume);
    }

    @Test
    void testCalculateLightingPower() {
        Room room1 = new Room();
        room1.setLight(20.0);
        Room room2 = new Room();
        room2.setLight(20.0);

        Level level1 = new Level();
        level1.setRooms(Arrays.asList(room1, room2));

        Room room3 = new Room();
        room3.setLight(40.0);
        Room room4 = new Room();
        room4.setLight(40.0);

        Level level2 = new Level();
        level2.setRooms(Arrays.asList(room3, room4));

        building.setLevels(Arrays.asList(level1, level2));
        double totalPower = building.calculateLightingPower();

        assertEquals(120.0, totalPower);
    }

    @Test
    void testCalculateHeatingEnergy() {
        Room room1 = new Room();
        room1.setHeating(500.0);
        Room room2 = new Room();
        room2.setHeating(500.0);

        Level level1 = new Level();
        level1.setRooms(Arrays.asList(room1, room2));

        Room room3 = new Room();
        room3.setHeating(1000.0);
        Room room4 = new Room();
        room4.setHeating(1000.0);

        Level level2 = new Level();
        level2.setRooms(Arrays.asList(room3, room4));

        building.setLevels(Arrays.asList(level1, level2));
        double totalEnergy = building.calculateHeatingEnergy();

        assertEquals(3000.0, totalEnergy);
    }
}