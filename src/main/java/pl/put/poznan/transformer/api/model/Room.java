package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Room {
    private static final Logger logger = LoggerFactory.getLogger(Room.class);
    private String id;
    private String name;
    private double area;
    private double cube;
    private double light;
    private double heating;

    public Room() {
        logger.info("Room object created");
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

    public double getArea() {
        logger.info("Getting area: {}", area);
        return area;
    }

    public void setArea(double area) {
        logger.info("Setting area: {}", area);
        this.area = area;
    }

    public double getCube() {
        logger.info("Getting cube: {}", cube);
        return cube;
    }

    public void setCube(double cube) {
        logger.info("Setting cube: {}", cube);
        this.cube = cube;
    }

    public double getLight() {
        logger.info("Getting light: {}", light);
        return light;
    }

    public void setLight(double light) {
        logger.info("Setting light: {}", light);
        this.light = light;
    }

    public double getHeating() {
        logger.info("Getting heating: {}", heating);
        return heating;
    }

    public void setHeating(double heating) {
        logger.info("Setting heating: {}", heating);
        this.heating = heating;
    }

    public double calculateArea() {
        logger.info("Calculating area for room: {}", id);
        logger.debug("Area for room {}: {}", id, area);
        return area;
    }

    public double calculateVolume() {
        logger.info("Calculating volume for room: {}", id);
        logger.debug("Volume for room {}: {}", id, cube);
        return cube;
    }

    public double calculateLightingPower() {
        logger.info("Calculating lighting power for room: {}", id);
        logger.debug("Lighting power for room {}: {}", id, light);
        return light;
    }
}
