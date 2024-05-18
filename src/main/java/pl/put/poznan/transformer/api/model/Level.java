package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Level {
    private static final Logger logger = LoggerFactory.getLogger(Level.class);
    private String id;
    private String name;
    private List<Room> rooms;

    public Level() {
        logger.info("Level object created");
    }

    public String getId() {
        logger.info("Getting ID: {}", id);
        return id;
    }

    public void setId(String id) {
        logger.info("Setting ID: {}", id);
        this.id = id;
    }

    public String getName() {
        logger.info("Getting name: {}", name);
        return name;
    }

    public void setName(String name) {
        logger.info("Setting name: {}", name);
        this.name = name;
    }

    public List<Room> getRooms() {
        logger.info("Getting rooms");
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        logger.info("Setting rooms: {}", rooms);
        this.rooms = rooms;
    }

    public double calculateArea() {
        logger.info("Calculating total area for level: {}", id);
        double totalArea = rooms.stream().mapToDouble(Room::calculateArea).sum();
        logger.debug("Total area for level {}: {}", id, totalArea);
        return totalArea;
    }

    public double calculateVolume() {
        logger.info("Calculating total volume for level: {}", id);
        double totalVolume = rooms.stream().mapToDouble(Room::calculateVolume).sum();
        logger.debug("Total volume for level {}: {}", id, totalVolume);
        return totalVolume;
    }
}
