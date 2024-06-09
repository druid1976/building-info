package pl.put.poznan.buildinginfo.api.model.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

/**
 * A visitor class implementing {@link BuildingComponentVisitor} for processing specific
 * tasks on building components. This visitor provides a structure for implementing
 * operations or calculations that are specific to different types of building components
 * like Buildings, Levels, and Rooms.
 */
public class ConcreteVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteVisitor.class);

    /**
     * Visits a {@link Building} and performs operations specific to a building.
     * This method should be expanded with logic specific to handling a building.
     *
     * @param building the building to visit
     */
    @Override
    public void visit(Building building) {
        logger.info("Visiting building: {}", building.getId());
        // Implement your logic here for when the visitor visits a Building
    }

    /**
     * Visits a {@link Level} and performs operations specific to a level.
     * This method should be expanded with logic specific to handling a level.
     *
     * @param level the level to visit
     */
    @Override
    public void visit(Level level) {
        logger.info("Visiting level: {}", level.getId());
        // Implement your logic here for when the visitor visits a Level
    }

    /**
     * Visits a {@link Room} and performs operations specific to a room.
     * This method is currently implemented to calculate and log the lighting power of the room.
     *
     * @param room the room to visit
     */
    @Override
    public void visit(Room room) {
        logger.info("Visiting room: {}", room.getId());
        // Additional logic can be implemented here for when the visitor visits a Room
        double lightingPower = room.calculateLightingPower();
        logger.debug("Lighting power for room {}: {}", room.getId(), lightingPower);
    }
}
