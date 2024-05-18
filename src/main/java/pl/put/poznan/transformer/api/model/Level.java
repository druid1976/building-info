package pl.put.poznan.transformer.api.model;

import java.util.List;

public class Level implements BuildingComponent {
    private String id;
    private String name;
    private List<Room> rooms;

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public double calculateArea() {
        return rooms.stream().mapToDouble(Room::calculateArea).sum();
    }

    @Override
    public double calculateVolume() {
        return rooms.stream().mapToDouble(Room::calculateVolume).sum();
    }

    @Override
    public double calculateLightingPower() {
        return rooms.stream().mapToDouble(Room::calculateLightingPower).sum();
    }

    @Override
    public double calculateHeatingEnergy() {
        return rooms.stream().mapToDouble(Room::calculateHeatingEnergy).sum();
    }

    public void accept(BuildingComponentVisitor visitor) {
        visitor.visit(this);
        for (Room room : rooms) {
            room.accept(visitor);
        }
    }
}
