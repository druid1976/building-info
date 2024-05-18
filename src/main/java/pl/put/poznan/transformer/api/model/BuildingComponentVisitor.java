package pl.put.poznan.transformer.api.model;

public interface BuildingComponentVisitor {
    void visit(Building building);
    void visit(Level level);
    void visit(Room room);
}