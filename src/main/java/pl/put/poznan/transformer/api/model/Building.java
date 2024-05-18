package pl.put.poznan.transformer.api.model;

import java.util.List;

public class Building implements BuildingComponent {
    private String id;
    private String name;
    private List<Level> levels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    @Override
    public double calculateArea() {
        return levels.stream().mapToDouble(Level::calculateArea).sum();
    }

    @Override
    public double calculateVolume() {
        return levels.stream().mapToDouble(Level::calculateVolume).sum();
    }

    @Override
    public double calculateLightingPower() {
        return levels.stream().mapToDouble(Level::calculateLightingPower).sum();
    }

    @Override
    public double calculateHeatingEnergy() {
        return levels.stream().mapToDouble(Level::calculateHeatingEnergy).sum();
    }

    public void accept(BuildingComponentVisitor visitor) {
        visitor.visit(this);
        for (Level level : levels) {
            level.accept(visitor);
        }
    }
}