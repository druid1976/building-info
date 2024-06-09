package pl.put.poznan.buildinginfo.api.model;

import org.junit.Before;
import org.junit.Test;
import pl.put.poznan.buildinginfo.api.model.visitors.AreaAndVolumeVisitor;
import pl.put.poznan.buildinginfo.api.model.visitors.EnergyVisitor;
import pl.put.poznan.buildinginfo.api.model.visitors.LightVisitor;
import pl.put.poznan.buildinginfo.api.model.visitors.WaterVisitor;

import java.util.Arrays;

import static org.junit.Assert.*;

public class VisitorTester {

    private Building building;
    private Level level1;
    private Level level2;
    private Room room1;
    private Room room2;

    @Before
    public void setUp() {
        // Setup rooms
        room1 = new Room();
        room1.setArea(100);
        room1.setCube(200);
        room1.setLight(300);
        room1.setHeating(400);
        room1.setWater(500);

        room2 = new Room();
        room2.setArea(150);
        room2.setCube(250);
        room2.setLight(350);
        room2.setHeating(450);
        room2.setWater(550);

        // Setup levels
        level1 = new Level();
        level1.setRooms(Arrays.asList(room1));
        level2 = new Level();
        level2.setRooms(Arrays.asList(room2));

        // Setup building
        building = new Building();
        building.setLevels(Arrays.asList(level1, level2));
    }

    @Test
    public void testAreaAndVolumeVisitor() {
        AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
        building.accept(visitor);

        double expectedTotalArea = 100 + 150; // Sum of areas
        double expectedTotalVolume = 200 + 250; // Sum of volumes

        assertEquals(expectedTotalArea, visitor.getTotalArea(), 0.0);
        assertEquals(expectedTotalVolume, visitor.getTotalVolume(), 0.0);
    }

    @Test
    public void testEnergyVisitor() {
        EnergyVisitor visitor = new EnergyVisitor();
        building.accept(visitor);

        double expectedTotalEnergy = 400 + 450; // Sum of heating energy
        double expectedTotalVolume = 200 + 250; // Sum of volumes

        double expectedEnergyPerUnitVolume = expectedTotalEnergy / expectedTotalVolume;
        assertEquals(expectedEnergyPerUnitVolume, visitor.getAverageEnergyPerUnitVolume(), 0.001);
    }

    @Test
    public void testLightVisitor() {
        LightVisitor visitor = new LightVisitor();
        building.accept(visitor);

        double expectedTotalLight = 300 + 350; // Sum of lighting power
        double expectedTotalArea = 100 + 150; // Sum of areas

        double expectedLightPerUnitArea = expectedTotalLight / expectedTotalArea;
        assertEquals(expectedLightPerUnitArea, visitor.getAverageLightPerUnitArea(), 0.001);
    }

    @Test
    public void testWaterVisitor() {
        WaterVisitor visitor = new WaterVisitor();
        building.accept(visitor);

        double expectedTotalWater = 500 + 550; // Sum of water consumption
        double expectedTotalVolume = 200 + 250; // Sum of room volumes

        double expectedWaterPerUnitVolume = expectedTotalWater / expectedTotalVolume;
        assertEquals(expectedWaterPerUnitVolume, visitor.getWaterConsumptionPerUnitVolume(), 0.001);
    }
}
