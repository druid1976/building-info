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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







@Service
public class BuildingService {
    private static final Logger logger = LoggerFactory.getLogger(BuildingService.class);

    private List<Building> buildings;

    public BuildingService() {
        try {
            logger.info("Initializing BuildingService...");
            loadBuildingData();
            logger.info("Building data loaded successfully.");
        } catch (IOException e) {
            logger.error("Error loading building data", e);
        }
    }

    private void loadBuildingData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new ClassPathResource("building-data.json").getInputStream();
        buildings = objectMapper.readValue(inputStream, new TypeReference<List<Building>>() {});
    }

    public List<Building> getAllBuildings() {
        logger.debug("Retrieving all buildings");
        return buildings;
    }

    public Building getBuildingById(String id) {
        logger.info("Retrieving building with ID: {}", id);
        Building building = buildings.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
        logger.debug("Found building: {}", building);
        return building;
    }

    public Level getLevelById(String buildingId, String levelId) {
        logger.info("Retrieving level with ID: {} from building with ID: {}", levelId, buildingId);
        Building building = getBuildingById(buildingId);
        if (building != null) {
            Level level = building.getLevels().stream()
                    .filter(l -> l.getId().equals(levelId))
                    .findFirst()
                    .orElse(null);
            logger.debug("Found level: {}", level);
            return level;
        }
        return null;
    }

    public Room getRoomById(String buildingId, String levelId, String roomId) {
        logger.info("Retrieving room with ID: {} from level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            Room room = level.getRooms().stream()
                    .filter(r -> r.getId().equals(roomId))
                    .findFirst()
                    .orElse(null);
            logger.debug("Found room: {}", room);
            return room;
        }
        return null;
    }

    public ValueInfo getTotalAreaOfBuilding(String buildingId) {
        logger.info("Calculating total area of building with ID: {}", buildingId);
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalArea = building.calculateArea();
            logger.debug("Total area of building {}: {}", buildingId, totalArea);
            return new ValueInfo(totalArea);
        }
        return new ValueInfo(0);
    }
    public ValueInfo getTotalAreaOfLevel(String buildingId, String levelId) {
        logger.info("Calculating total area of level with ID: {} in building with ID: {}", levelId, buildingId);
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalArea = level.calculateArea();
            logger.debug("Total area of level {}: {}", levelId, totalArea);
            return new ValueInfo(totalArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAreaOfRoom(String buildingId, String levelId, String roomId) {
        logger.info("Calculating area of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            double area = room.calculateArea();
            logger.debug("Area of room {}: {}", roomId, area);
            return new ValueInfo(area);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalVolumeOfBuilding(String buildingId) {
        logger.info("Calculating total volume of building with ID: {}", buildingId);
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalVolume = building.calculateVolume();
            logger.debug("Total volume of building {}: {}", buildingId, totalVolume);
            return new ValueInfo(totalVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalVolumeOfLevel(String buildingId, String levelId) {
        logger.info("Calculating total volume of level with ID: {} in building with ID: {}", levelId, buildingId);
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalVolume = level.calculateVolume();
            logger.debug("Total volume of level {}: {}", levelId, totalVolume);
            return new ValueInfo(totalVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getVolumeOfRoom(String buildingId, String levelId, String roomId) {
        logger.info("Calculating volume of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            double volume = room.calculateVolume();
            logger.debug("Volume of room {}: {}", roomId, volume);
            return new ValueInfo(volume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getLightingPowerPerUnitAreaOfRoom(String buildingId, String levelId, String roomId) {
        logger.info("Calculating lighting power per unit area of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            double powerPerUnitArea = room.getLight() / room.getArea();
            logger.debug("Lighting power per unit area of room {}: {}", roomId, powerPerUnitArea);
            return new ValueInfo(powerPerUnitArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfLevel(String buildingId, String levelId) {
        logger.info("Calculating average lighting power per unit area of level with ID: {} in building with ID: {}", levelId, buildingId);
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalPower = level.getRooms().stream().mapToDouble(Room::getLight).sum();
            double totalArea = level.getRooms().stream().mapToDouble(Room::getArea).sum();
            double averagePowerPerUnitArea = totalPower / totalArea;
            logger.debug("Average lighting power per unit area of level {}: {}", levelId, averagePowerPerUnitArea);
            return new ValueInfo(averagePowerPerUnitArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfBuilding(String buildingId) {
        logger.info("Calculating average lighting power per unit area of building with ID: {}", buildingId);
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
            double averagePowerPerUnitArea = totalPower / totalArea;
            logger.debug("Average lighting power per unit area of building {}: {}", buildingId, averagePowerPerUnitArea);
            return new ValueInfo(averagePowerPerUnitArea);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(String buildingId, String levelId, String roomId) {
        logger.info("Calculating heating energy consumption per unit volume of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null && room.getCube() != 0) {
            double consumptionPerUnitVolume = room.getHeating() / room.getCube();
            logger.debug("Heating energy consumption per unit volume of room {}: {}", roomId, consumptionPerUnitVolume);
            return new ValueInfo(consumptionPerUnitVolume);
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(String buildingId, String levelId) {
        logger.info("Calculating average heating energy consumption per unit volume of level with ID: {} in building with ID: {}", levelId, buildingId);
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            double totalHeating = level.getRooms().stream().mapToDouble(Room::getHeating).sum();
            double totalVolume = level.getRooms().stream().mapToDouble(Room::getCube).sum();
            if (totalVolume != 0) {
                double averageConsumptionPerUnitVolume = totalHeating / totalVolume;
                logger.debug("Average heating energy consumption per unit volume of level {}: {}", levelId, averageConsumptionPerUnitVolume);
                return new ValueInfo(averageConsumptionPerUnitVolume);
            }
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(String buildingId) {
        logger.info("Calculating average heating energy consumption per unit volume of building with ID: {}", buildingId);
        Building building = getBuildingById(buildingId);
        if (building != null) {
            double totalHeating = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getHeating)
                    .sum();
            double totalVolume = building.getLevels().stream()
                    .flatMap(level -> level.getRooms().stream())
                    .mapToDouble(Room::getCube)
                    .sum();
            if (totalVolume != 0) {
                double averageConsumptionPerUnitVolume = totalHeating / totalVolume;
                logger.debug("Average heating energy consumption per unit volume of building {}: {}", buildingId, averageConsumptionPerUnitVolume);
                return new ValueInfo(averageConsumptionPerUnitVolume);
            }
        }
        return new ValueInfo(0);
    }

    public List<Room> getRoomsExceedingHeatLimit(String buildingId, double limit) {
        List<Room> roomsExceedingLimit = new ArrayList<>();
        logger.info("Checking if there exists any room which exceeds the heat limit in building with ID: {}", buildingId);
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
