package pl.put.poznan.buildinginfo.api.model.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

public class ConcreteVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteVisitor.class);

    @Override
    public void visit(Building building) {
        logger.info("Visiting building: {}", building.getId());
        // Add your logic here for when the visitor visits a Building
    }

    @Override
    public void visit(Level level) {
        logger.info("Visiting level: {}", level.getId());
        // Add your logic here for when the visitor visits a Level
    }

    @Override
    public void visit(Room room) {
        logger.info("Visiting room: {}", room.getId());
        // Add your logic here for when the visitor visits a Room
        double lightingPower = room.calculateLightingPower();
        logger.debug("Lighting power for room {}: {}", room.getId(), lightingPower);
    }
}
