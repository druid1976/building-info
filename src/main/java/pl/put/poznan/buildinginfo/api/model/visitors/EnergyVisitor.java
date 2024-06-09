package pl.put.poznan.buildinginfo.api.model.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

/**
 * A visitor class for calculating the total energy consumption and the corresponding
 * volume of building components such as Buildings, Levels, and Rooms. This class
 * implements the {@link BuildingComponentVisitor} interface and computes the average
 * energy per unit volume after visiting all applicable components.
 */
public class EnergyVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(EnergyVisitor.class);

    /** Accumulated total energy consumption from all visited building components. */
    private double totalEnergy = 0;

    /** Accumulated total volume of all visited building components. */
    private double totalVolume = 0;

    /**
     * Calculates and returns the average energy consumption per unit volume.
     * If no volume has been recorded, returns 0 to avoid division by zero.
     *
     * @return the average energy per unit volume, or 0 if total volume is zero
     */
    public double getAverageEnergyPerUnitVolume() {
        return totalVolume > 0 ? totalEnergy / totalVolume : 0;
    }

    /**
     * Visits a {@link Building} and updates the total energy and volume based on
     * the building's calculated heating energy and volume.
     *
     * @param building the building to visit
     */
    @Override
    public void visit(Building building) {
        logger.info("Visiting building for energy calculations: {}", building.getId());
        totalEnergy += building.calculateHeatingEnergy();
        totalVolume += building.calculateVolume();
    }

    /**
     * Visits a {@link Level} and updates the total energy and volume based on
     * the level's calculated heating energy and volume.
     *
     * @param level the level to visit
     */
    @Override
    public void visit(Level level) {
        logger.info("Visiting level for energy calculations: {}", level.getId());
        totalEnergy += level.calculateHeatingEnergy();
        totalVolume += level.calculateVolume();
    }

    /**
     * Visits a {@link Room} and updates the total energy and volume based on
     * the room's calculated heating energy and volume.
     *
     * @param room the room to visit
     */
    @Override
    public void visit(Room room) {
        logger.info("Visiting room for energy calculations: {}", room.getId());
        totalEnergy += room.calculateHeatingEnergy();
        totalVolume += room.calculateVolume();
    }
}
