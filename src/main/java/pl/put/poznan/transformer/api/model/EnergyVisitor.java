package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnergyVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(EnergyVisitor.class);

    private double totalEnergy = 0;
    private double totalVolume = 0;

    public double getAverageEnergyPerUnitVolume() {
        return totalVolume > 0 ? totalEnergy / totalVolume : 0;
    }

    @Override
    public void visit(Building building) {
        logger.info("Visiting building for energy calculations: {}", building.getId());
        totalEnergy += building.calculateHeatingEnergy();
        totalVolume += building.calculateVolume();
    }

    @Override
    public void visit(Level level) {
        logger.info("Visiting level for energy calculations: {}", level.getId());
        totalEnergy += level.calculateHeatingEnergy();
        totalVolume += level.calculateVolume();
    }

    @Override
    public void visit(Room room) {
        logger.info("Visiting room for energy calculations: {}", room.getId());
        totalEnergy += room.calculateHeatingEnergy();
        totalVolume += room.calculateVolume();
    }
}
