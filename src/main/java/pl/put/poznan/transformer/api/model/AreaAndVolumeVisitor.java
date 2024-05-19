package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaAndVolumeVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(AreaAndVolumeVisitor.class);

    private double totalArea = 0;
    private double totalVolume = 0;

    public double getTotalArea() {
        return totalArea;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    @Override
    public void visit(Building building) {
        logger.info("Visiting building for area and volume: {}", building.getId());
        totalArea += building.calculateArea();
        totalVolume += building.calculateVolume();
    }

    @Override
    public void visit(Level level) {
        logger.info("Visiting level for area and volume: {}", level.getId());
        totalArea += level.calculateArea();
        totalVolume += level.calculateVolume();
    }

    @Override
    public void visit(Room room) {
        logger.info("Visiting room for area and volume: {}", room.getId());
        totalArea += room.calculateArea();
        totalVolume += room.calculateVolume();
    }
}
