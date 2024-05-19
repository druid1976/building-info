package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Room class represents a room in a building level.
 * It provides methods to calculate the area, volume, and lighting power of the room.
 */
public class Room implements BuildingComponent{
    private static final Logger logger = LoggerFactory.getLogger(Room.class);
    private String id;
    private String name;
    private double area;
    private double cube;
    private double light;
    private double heating;

    /**
     * Constructs a new Room.
     */
    public Room() {
        logger.info("Room object created");
    }

    /**
     * Gets the ID of the room.
     * @return the ID of the room.
     */
    public String getId() {
        logger.info("Getting ID: {}", id);
        return id;
    }

    /**
     * Sets the ID of the room.
     * @param id the new ID of the room.
     */
    public void setId(String id) {
        logger.info("Setting ID: {}", id);
        this.id = id;
    }

    /**
     * Gets the name of the room.
     * @return the name of the room.
     */
    public String getName() {
        logger.info("Getting name: {}", name);
        return name;
    }

    /**
     * Sets the name of the room.
     * @param name the new name of the room.
     */
    public void setName(String name) {
        logger.info("Setting name: {}", name);
        this.name = name;
    }

    /**
     * Gets the area of the room.
     * @return the area of the room.
     */
    public double getArea() {
        logger.info("Getting area: {}", area);
        return area;
    }

    /**
     * Sets the area of the room.
     * @param area the new area of the room.
     */
    public void setArea(double area) {
        logger.info("Setting area: {}", area);
        this.area = area;
    }

    /**
     * Gets the volume (cube) of the room.
     * @return the volume of the room.
     */
    public double getCube() {
        logger.info("Getting cube: {}", cube);
        return cube;
    }

    /**
     * Sets the volume (cube) of the room.
     * @param cube the new volume of the room.
     */
    public void setCube(double cube) {
        logger.info("Setting cube: {}", cube);
        this.cube = cube;
    }

    /**
     * Gets the lighting power of the room.
     * @return the lighting power of the room.
     */
    public double getLight() {
        logger.info("Getting light: {}", light);
        return light;
    }

    /**
     * Sets the lighting power of the room.
     * @param light the new lighting power of the room.
     */
    public void setLight(double light) {
        logger.info("Setting light: {}", light);
        this.light = light;
    }

    /**
     * Gets the heating power of the room.
     * @return the heating power of the room.
     */
    public double getHeating() {
        logger.info("Getting heating: {}", heating);
        return heating;
    }

    /**
     * Sets the heating power of the room.
     * @param heating the new heating power of the room.
     */
    public void setHeating(double heating) {
        logger.info("Setting heating: {}", heating);
        this.heating = heating;
    }

    /**
     * Calculates the area of the room.
     * @return the area of the room.
     */
    public double calculateArea() {
        logger.info("Calculating area for room: {}", id);
        logger.debug("Area for room {}: {}", id, area);
        return area;
    }

    /**
     * Calculates the volume of the room.
     * @return the volume of the room.
     */
    public double calculateVolume() {
        logger.info("Calculating volume for room: {}", id);
        logger.debug("Volume for room {}: {}", id, cube);
        return cube;
    }

    /**
     * Calculates the lighting power of the room.
     * @return the lighting power of the room.
     */
    public double calculateLightingPower() {
        logger.info("Calculating lighting power for room: {}", id);
        logger.debug("Lighting power for room {}: {}", id, light);
        return light;
    }

    /**
     * Calculates the heating energy of the room.
     * @return the heating energy of the room.
     */
    @Override
    public double calculateHeatingEnergy() {
        logger.info("Calculating heating energy for room: {}", id);
        logger.debug("Heating energy for room {}: {}", id, heating);
        return heating;
    }

    /**
     * Accepts a visitor to perform operations on the room.
     * @param visitor the visitor to accept.
     */
    @Override
    public void accept(BuildingComponentVisitor visitor) {
        logger.info("Accepting visitor for room: {}", id);
        visitor.visit(this);
    }
}


