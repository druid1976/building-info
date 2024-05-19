package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * The Level class represents a level in a building containing multiple rooms.
 * It provides methods to calculate the total area and volume of the level.
 */
public class Level {
    private static final Logger logger = LoggerFactory.getLogger(Level.class);
    private String id;
    private String name;
    private List<Room> rooms;

    /**
     * Constructs a new Level.
     */
    public Level() {
        logger.info("Level object created");
    }

    /**
     * Gets the ID of the level.
     * @return the ID of the level.
     */
    public String getId() {
        logger.info("Getting ID: {}", id);
        return id;
    }

    /**
     * Sets the ID of the level.
     * @param id the new ID of the level.
     */
    public void setId(String id) {
        logger.info("Setting ID: {}", id);
        this.id = id;
    }

    /**
     * Gets the name of the level.
     * @return the name of the level.
     */
    public String getName() {
        logger.info("Getting name: {}", name);
        return name;
    }

    /**
     * Sets the name of the level.
     * @param name the new name of the level.
     */
    public void setName(String name) {
        logger.info("Setting name: {}", name);
        this.name = name;
    }

    /**
     * Gets the rooms in the level.
     * @return the list of rooms.
     */
    public List<Room> getRooms() {
        logger.info("Getting rooms");
        return rooms;
    }

    /**
     * Sets the rooms in the level.
     * @param rooms the new list of rooms.
     */
    public void setRooms(List<Room> rooms) {
        logger.info("Setting rooms: {}", rooms);
        this.rooms = rooms;
    }

    /**
     * Calculates the total area of the level.
     * @return the total area of the level.
     */
    public double calculateArea() {
        logger.info("Calculating total area for level: {}", id);
        double totalArea = rooms.stream().mapToDouble(Room::calculateArea).sum();
        logger.debug("Total area for level {}: {}", id, totalArea);
        return totalArea;
    }

    /**
     * Calculates the total volume of the level.
     * @return the total volume of the level.
     */
    public double calculateVolume() {
        logger.info("Calculating total volume for level: {}", id);
        double totalVolume = rooms.stream().mapToDouble(Room::calculateVolume).sum();
        logger.debug("Total volume for level {}: {}", id, totalVolume);
        return totalVolume;
    }
}
