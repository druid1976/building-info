package pl.put.poznan.buildinginfo.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.put.poznan.buildinginfo.api.model.visitors.BuildingComponentVisitor;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BuildingMockTest {
    @Mock
    BuildingComponentVisitor mockVisitor;

    Building building;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        building = new Building();
        building.setId("1");
        building.setName("Test Building");
        List<Level> levels = new ArrayList<>();

        Level mockLevel1 = mock(Level.class);
        Level mockLevel2 = mock(Level.class);
        levels.add(mockLevel1);
        levels.add(mockLevel2);
        building.setLevels(levels);
    }

    @Test
    void testCalculateArea() {
        when(building.getLevels().get(0).calculateArea()).thenReturn(100.0);
        when(building.getLevels().get(1).calculateArea()).thenReturn(200.0);

        double expectedArea = 300.0;
        double actualArea = building.calculateArea();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    void testCalculateVolume() {
        when(building.getLevels().get(0).calculateVolume()).thenReturn(50.0);
        when(building.getLevels().get(1).calculateVolume()).thenReturn(100.0);

        double expectedVolume = 150.0;
        double actualVolume = building.calculateVolume();

        assertEquals(expectedVolume, actualVolume);
    }

    @Test
    void testCalculateLightingPower() {
        when(building.getLevels().get(0).calculateLightingPower()).thenReturn(50.0);
        when(building.getLevels().get(1).calculateLightingPower()).thenReturn(100.0);

        double expectedPower = 150.0;
        double actualPower = building.calculateLightingPower();

        assertEquals(expectedPower, actualPower);
    }

    @Test
    void testCalculateHeatingEnergy() {
        when(building.getLevels().get(0).calculateHeatingEnergy()).thenReturn(20.0);
        when(building.getLevels().get(1).calculateHeatingEnergy()).thenReturn(30.0);

        double expectedEnergy = 50.0;
        double actualEnergy = building.calculateHeatingEnergy();

        assertEquals(expectedEnergy, actualEnergy);
    }

    @Test
    void testAccept() {
        building.accept(mockVisitor);
        verify(mockVisitor).visit(building);
    }
}


