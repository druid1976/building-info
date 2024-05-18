package pl.put.poznan.transformer.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.api.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private List<Building> buildings;

    public BuildingService() {
        try {
            loadBuildingData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBuildingData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("building-data.json").getInputStream();
        buildings = objectMapper.readValue(inputStream, new TypeReference<List<Building>>() {});
    }

    public List<Building> getAllBuildings() {
        return buildings;
    }

    public Building getBuildingById(String id) {
        return buildings.stream()
                .filter(building -> building.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Level getLevelById(String buildingId, String levelId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            return building.getLevels().stream()
                    .filter(level -> level.getId().equals(levelId))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public Room getRoomById(String buildingId, String levelId, String roomId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            return level.getRooms().stream()
                    .filter(room -> room.getId().equals(roomId))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public ValueInfo getTotalAreaOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalArea = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getArea)
                    .sum();
            return new ValueInfo(totalArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalAreaOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalArea = level.getRooms().stream()
                    .mapToDouble(Room::getArea)
                    .sum();
            return new ValueInfo(totalArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAreaOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            return new ValueInfo(room.getArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalVolumeOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalVolume = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getCube)
                    .sum();
            return new ValueInfo(totalVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalVolumeOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalVolume = level.getRooms().stream()
                    .mapToDouble(Room::getCube)
                    .sum();
            return new ValueInfo(totalVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getVolumeOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            return new ValueInfo(room.getCube());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getLightingPowerPerUnitAreaOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            double powerPerUnitArea = room.getLight() / room.getArea();
            return new ValueInfo(powerPerUnitArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalPower = level.getRooms().stream().mapToDouble(Room::getLight).sum();
            double totalArea = level.getRooms().stream().mapToDouble(Room::getArea).sum();
            return new ValueInfo(totalPower / totalArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalPower = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getLight)
                    .sum();
            double totalArea = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getArea)
                    .sum();
            return new ValueInfo(totalPower / totalArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null && room.getCube() != 0) {
            double consumptionPerUnitVolume = room.getHeating() / room.getCube();
            return new ValueInfo(consumptionPerUnitVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalConsumption = level.getRooms().stream().mapToDouble(Room::getHeating).sum();
            double totalVolume = level.getRooms().stream().mapToDouble(Room::getCube).sum();
            return new ValueInfo(totalConsumption / totalVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalConsumption = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getHeating)
                    .sum();
            double totalVolume = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getCube)
                    .sum();
            return new ValueInfo(totalConsumption / totalVolume);
        }
        return new ValueInfo(0);
    }

    public List<Room> getRoomsExceedingHeatLimit(String buildingId, double limit) {
        List<Room> roomsExceedingLimit = new ArrayList<>();
        Building building = getBuildingById(buildingId);
        if (building != null) {
            building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .filter(room -> room.getHeating() / room.getCube() > limit)
                    .forEach(roomsExceedingLimit::add);
        }
        return roomsExceedingLimit;
    }

    public void applyVisitorToBuilding(String buildingId, BuildingComponentVisitor visitor) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            building.accept(visitor);
        }
    }
}
