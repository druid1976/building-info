package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(LightVisitor.class);

    private double totalLight = 0;
    private double totalArea = 0;

    public double getAverageLightPerUnitArea() {
        return totalArea > 0 ? totalLight / totalArea : 0;
    }

    @Override
    public void visit(Building building) {
        logger.info("Visiting building for lighting calculations: {}", building.getId());
        totalLight += building.calculateLightingPower();
        totalArea += building.calculateArea();
    }

    @Override
    public void visit(Level level) {
        logger.info("Visiting level for lighting calculations: {}", level.getId());
        totalLight += level.calculateLightingPower();
        totalArea += level.calculateArea();
    }

    @Override
    public void visit(Room room) {
        logger.info("Visiting room for lighting calculations: {}", room.getId());
        totalLight += room.calculateLightingPower();
        totalArea += room.calculateArea();
    }
}
