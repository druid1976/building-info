package pl.put.poznan.buildinginfo.api.model.visitors;

import pl.put.poznan.buildinginfo.api.model.Building;
import pl.put.poznan.buildinginfo.api.model.Level;
import pl.put.poznan.buildinginfo.api.model.Room;

public interface BuildingComponentVisitor {
    void visit(Building building);
    void visit(Level level);
    void visit(Room room);
}
