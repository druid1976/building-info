package pl.put.poznan.transformer.api.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Building {
    private static final Logger logger = LoggerFactory.getLogger(Building.class);
    private String id;
    private String name;
    private List<Level> levels;

    public Building() {
        logger.info("Building object created");
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

    public List<Level> getLevels() {
        logger.info("Getting levels");
        return levels;
    }

    public void setLevels(List<Level> levels) {
        logger.info("Setting levels: {}", levels);
        this.levels = levels;
    }

    public double calculateArea() {
        logger.info("Calculating total area for building: {}", id);
        double totalArea = levels.stream().mapToDouble(Level::calculateArea).sum();
        logger.debug("Total area for building {}: {}", id, totalArea);
        return totalArea;
    }

    public double calculateVolume() {
        logger.info("Calculating total volume for building: {}", id);
        double totalVolume = levels.stream().mapToDouble(Level::calculateVolume).sum();
        logger.debug("Total volume for building {}: {}", id, totalVolume);
        return totalVolume;
    }

    public void accept(BuildingComponentVisitor visitor) {
        logger.info("Accepting visitor for building: {}", id);
        visitor.visit(this);
    }
}
