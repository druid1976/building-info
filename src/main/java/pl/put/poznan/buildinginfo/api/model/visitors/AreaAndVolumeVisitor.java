package pl.put.poznan.buildinginfo.api.model.visitors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

/**
 * A visitor class for calculating the total area and volume of a building structure.
 * This class implements the {@link BuildingComponentVisitor} interface and accumulates
 * the total area and volume as it visits different components of a building such as
 * buildings, levels, and rooms.
 */
public class AreaAndVolumeVisitor implements BuildingComponentVisitor {
    private static final Logger logger = LoggerFactory.getLogger(AreaAndVolumeVisitor.class);

    /** The cumulative total area of the visited building components. */
    private double totalArea = 0;

    /** The cumulative total volume of the visited building components. */
    private double totalVolume = 0;

    /**
     * Returns the total area calculated by the visitor.
     *
     * @return the total area of the building components visited
     */
    public double getTotalArea() {
        return totalArea;
    }

    /**
     * Returns the total volume calculated by the visitor.
     *
     * @return the total volume of the building components visited
     */
    public double getTotalVolume() {
        return totalVolume;
    }

    /**
     * Visits a {@link Building} to calculate its area and volume.
     * Logs the activity and updates the total area and volume.
     *
     * @param building the building to visit
     */
    @Override
    public void visit(Building building) {
        logger.info("Visiting building for area and volume: {}", building.getId());
        totalArea += building.calculateArea();
        totalVolume += building.calculateVolume();
    }

    /**
     * Visits a {@link Level} to calculate its area and volume.
     * Logs the activity and updates the total area and volume.
     *
     * @param level the level to visit
     */
    @Override
    public void visit(Level level) {
        logger.info("Visiting level for area and volume: {}", level.getId());
        totalArea += level.calculateArea();
        totalVolume += level.calculateVolume();
    }

    /**
     * Visits a {@link Room} to calculate its area and volume.
     * Logs the activity and updates the total area and volume.
     *
     * @param room the room to visit
     */
    @Override
    public void visit(Room room) {
        logger.info("Visiting room for area and volume: {}", room.getId());
        totalArea += room.calculateArea();
        totalVolume += room.calculateVolume();
    }
}
