// ConcreteVisitor.java
package pl.put.poznan.transformer.api.model;

public class ConcreteVisitor implements BuildingComponentVisitor {
    @Override
    public void visit(Building building) {
        // Example: Calculate total area
        System.out.println("Total area of building: " + building.calculateArea());
    }

    @Override
    public void visit(Level level) {
        // Example: Calculate total volume
        System.out.println("Total volume of level: " + level.calculateVolume());
    }

    @Override
    public void visit(Room room) {
        // Example: Calculate lighting power
        System.out.println("Lighting power of room: " + room.calculateLightingPower());
    }
}
