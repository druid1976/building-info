package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * The Building class represents a building containing multiple levels.
 * It provides methods to calculate the total area and volume of the building.
 */
public class Building {
    private static final Logger logger = LoggerFactory.getLogger(Building.class);
    private String id;
    private String name;
    private List<Level> levels;

    /**
     * Constructs a new Building.
     */
    public Building() {
        logger.info("Building object created");
    }

    /**
     * Gets the ID of the building.
     * @return the ID of the building.
     */
    public String getId() {
        logger.info("Getting ID: {}", id);
        return id;
    }

    /**
     * Sets the ID of the building.
     * @param id the new ID of the building.
     */
    public void setId(String id) {
        logger.info("Setting ID: {}", id);
        this.id = id;
    }

    /**
     * Gets the name of the building.
     * @return the name of the building.
     */
    public String getName() {
        logger.info("Getting name: {}", name);
        return name;
    }

    /**
     * Sets the name of the building.
     * @param name the new name of the building.
     */
    public void setName(String name) {
        logger.info("Setting name: {}", name);
        this.name = name;
    }

    /**
     * Gets the levels of the building.
     * @return the list of levels.
     */
    public List<Level> getLevels() {
        logger.info("Getting levels");
        return levels;
    }

    /**
     * Sets the levels of the building.
     * @param levels the new list of levels.
     */
    public void setLevels(List<Level> levels) {
        logger.info("Setting levels: {}", levels);
        this.levels = levels;
    }

    /**
     * Calculates the total area of the building.
     * @return the total area of the building.
     */
    public double calculateArea() {
        logger.info("Calculating total area for building: {}", id);
        double totalArea = levels.stream().mapToDouble(Level::calculateArea).sum();
        logger.debug("Total area for building {}: {}", id, totalArea);
        return totalArea;
    }

    /**
     * Calculates the total volume of the building.
     * @return the total volume of the building.
     */
    public double calculateVolume() {
        logger.info("Calculating total volume for building: {}", id);
        double totalVolume = levels.stream().mapToDouble(Level::calculateVolume).sum();
        logger.debug("Total volume for building {}: {}", id, totalVolume);
        return totalVolume;
    }

    /**
     * Accepts a visitor to perform operations on the building.
     * @param visitor the visitor to accept.
     */
    public void accept(BuildingComponentVisitor visitor) {
        logger.info("Accepting visitor for building: {}", id);
        visitor.visit(this);
    }
}
