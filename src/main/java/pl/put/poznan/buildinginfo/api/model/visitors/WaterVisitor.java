package pl.put.poznan.buildinginfo.api.model.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

public class WaterVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(WaterVisitor.class);
    private double totalWaterConsumption;
    private double totalVolume;

    @Override
    public void visit(Building building) {
        logger.info("Visiting building: {}", building.getId());
        building.getLevels().forEach(level -> level.accept(this));
    }

    @Override
    public void visit(Level level) {
        logger.info("Visiting level: {}", level.getId());
        level.getRooms().forEach(room -> room.accept(this));
    }

    @Override
    public void visit(Room room) {
        logger.info("Visiting room: {}", room.getId());
        totalWaterConsumption += room.getWater();
        totalVolume += room.getCube();
    }

    public double getWaterConsumptionPerUnitVolume() {
        return totalVolume == 0 ? 0 : totalWaterConsumption / totalVolume;
    }
}
