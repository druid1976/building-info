package pl.put.poznan.buildinginfo.api.model.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

/**
 * A visitor class that calculates the total lighting power and the total area of various
 * building components (Buildings, Levels, and Rooms). This class implements the
 * {@link BuildingComponentVisitor} interface to compute the average lighting power per unit
 * area after visiting all applicable building components.
 */
public class LightVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(LightVisitor.class);

    /** Total accumulated lighting power from all visited building components. */
    private double totalLight = 0;

    /** Total accumulated area from all visited building components. */
    private double totalArea = 0;

    /**
     * Calculates and returns the average lighting power per unit area.
     * If no area has been recorded, returns 0 to prevent division by zero.
     *
     * @return the average lighting power per unit area, or 0 if total area is zero
     */
    public double getAverageLightPerUnitArea() {
        return totalArea > 0 ? totalLight / totalArea : 0;
    }

    /**
     * Visits a {@link Building} and updates the total light and area based on
     * the building's calculated lighting power and area.
     *
     * @param building the building to visit
     */
    @Override
    public void visit(Building building) {
        logger.info("Visiting building for lighting calculations: {}", building.getId());
        totalLight += building.calculateLightingPower();
        totalArea += building.calculateArea();
    }

    /**
     * Visits a {@link Level} and updates the total light and area based on
     * the level's calculated lighting power and area.
     *
     * @param level the level to visit
     */
    @Override
    public void visit(Level level) {
        logger.info("Visiting level for lighting calculations: {}", level.getId());
        totalLight += level.calculateLightingPower();
        totalArea += level.calculateArea();
    }

    /**
     * Visits a {@link Room} and updates the total light and area based on
     * the room's calculated lighting power and area.
     *
     * @param room the room to visit
     */
    @Override
    public void visit(Room room) {
        logger.info("Visiting room for lighting calculations: {}", room.getId());
        totalLight += room.calculateLightingPower();
        totalArea += room.calculateArea();
    }
}
