package pl.put.poznan.transformer.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.api.model.ValueInfo;
import pl.put.poznan.transformer.api.model.Building;
import pl.put.poznan.transformer.api.model.Level;
import pl.put.poznan.transformer.api.model.Room;

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
            // Handle exception
        }
    }

    private void loadBuildingData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("building-data.json").getInputStream();
        buildings = objectMapper.readValue(inputStream, new TypeReference<List<Building>>() {});
    }

    public Building getBuildingById(String id) {
        Optional<Building> optionalBuilding = buildings.stream()
                .filter(building -> building.getId().equals(id))
                .findFirst();
        return optionalBuilding.orElse(null);
    }

    public Level getLevelById(String buildingId, String levelId) {
        Optional<Building> optionalBuilding = buildings.stream()
                .filter(building -> building.getId().equals(buildingId))
                .findFirst();
        if (optionalBuilding.isPresent()) {
            Optional<Level> optionalLevel = optionalBuilding.get().getLevels().stream()
                    .filter(level -> level.getId().equals(levelId))
                    .findFirst();
            return optionalLevel.orElse(null);
        }
        return null;
    }

    public Room getRoomById(String buildingId, String levelId, String roomId) {
        Optional<Building> optionalBuilding = buildings.stream()
                .filter(building -> building.getId().equals(buildingId))
                .findFirst();
        if (optionalBuilding.isPresent()) {
            Optional<Level> optionalLevel = optionalBuilding.get().getLevels().stream()
                    .filter(level -> level.getId().equals(levelId))
                    .findFirst();
            if (optionalLevel.isPresent()) {
                Optional<Room> optionalRoom = optionalLevel.get().getRooms().stream()
                        .filter(room -> room.getId().equals(roomId))
                        .findFirst();
                return optionalRoom.orElse(null);
            }
        }
        return null;
    }

    /* AREA INFO LOGIC */
    public ValueInfo getTotalAreaOfBuilding(String buildingId) {
        double totalArea = 0.0;
        Building building = getBuildingById(buildingId);
        if (building != null) {
            totalArea = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getArea)
                    .sum();
        }
        return new ValueInfo(totalArea);
    }

    public ValueInfo getTotalAreaOfLevel(String buildingId, String levelId) {
        double totalArea = 0.0;
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            totalArea = level.getRooms().stream()
                    .mapToDouble(Room::getArea)
                    .sum();
        }
        return new ValueInfo(totalArea);
    }

    public ValueInfo getAreaOfRoom(String buildingId, String levelId, String roomId) {
        double area = 0.0;
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            area = room.getArea();
        }
        return new ValueInfo(area);
    }

    /* VOLUME INFO LOGIC */
    public ValueInfo getTotalVolumeOfBuilding(String buildingId) {
        double totalVolume = 0.0;
        Building building = getBuildingById(buildingId);
        if (building != null) {
            totalVolume = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getCube)
                    .sum();
        }
        return new ValueInfo(totalVolume);
    }

    public ValueInfo getTotalVolumeOfLevel(String buildingId, String levelId) {
        double totalVolume = 0.0;
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            totalVolume = level.getRooms().stream()
                    .mapToDouble(Room::getCube)
                    .sum();
        }
        return new ValueInfo(totalVolume);
    }

    public ValueInfo getVolumeOfRoom(String buildingId, String levelId, String roomId) {
        double volume = 0.0;
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            volume = room.getCube();
        }
        return new ValueInfo(volume);
    }

    /* Lightning power logic */
    public ValueInfo getLightingPowerPerUnitAreaOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            double powerPerUnitArea = room.getLight() / room.getArea();
            return new ValueInfo(powerPerUnitArea);
        }
        return null;
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalPower = 0.0;
            double totalArea = 0.0;
            for (Room room : level.getRooms()) {
                totalPower += room.getLight();
                totalArea += room.getArea();
            }
            double averagePowerPerUnitArea = totalPower / totalArea;
            return new ValueInfo(averagePowerPerUnitArea);
        }
        return null;
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalPower = 0.0;
            double totalArea = 0.0;
            for (Level level : building.getLevels()) {
                for (Room room : level.getRooms()) {
                    totalPower += room.getLight();
                    totalArea += room.getArea();
                }
            }
            double averagePowerPerUnitArea = totalPower / totalArea;
            return new ValueInfo(averagePowerPerUnitArea);
        }
        return null;
    }

    /* HEATING LOGIC */
    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null && room.getCube() != 0) {
            double consumptionPerUnitVolume = room.getHeating() / room.getCube();
            return new ValueInfo(consumptionPerUnitVolume);
        }
        return null;
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalConsumption = 0.0;
            double totalVolume = 0.0;
            for (Room room : level.getRooms()) {
                totalConsumption += room.getHeating();
                totalVolume += room.getCube();
            }
            double averageConsumptionPerUnitVolume = totalConsumption / totalVolume;
            return new ValueInfo(averageConsumptionPerUnitVolume);
        }
        return null;
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalConsumption = 0.0;
            double totalVolume = 0.0;
            for (Level level : building.getLevels()) {
                for (Room room : level.getRooms()) {
                    totalConsumption += room.getHeating();
                    totalVolume += room.getCube();
                }
            }
            double averageConsumptionPerUnitVolume = totalConsumption / totalVolume;
            return new ValueInfo(averageConsumptionPerUnitVolume);
        }
        return null;
    }
    /* exceeding logic */
    public List<Room> getRoomsExceedingHeatLimit(String buildingId, double limit) {
        List<Room> roomsExceedingLimit = new ArrayList<>();
        Building building = getBuildingById(buildingId);
        if (building != null) {
            for (Level level : building.getLevels()) {
                for (Room room : level.getRooms()) {
                    double heatPerUnitVolume = room.getHeating() / room.getCube();
                    if (heatPerUnitVolume > limit) {
                        roomsExceedingLimit.add(room);
                    }
                }
            }
        }
        return roomsExceedingLimit;
    }
}



