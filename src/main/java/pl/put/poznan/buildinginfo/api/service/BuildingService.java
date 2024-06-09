package pl.put.poznan.buildinginfo.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import pl.put.poznan.buildinginfo.api.model.*;
import pl.put.poznan.buildinginfo.api.model.visitors.AreaAndVolumeVisitor;
import pl.put.poznan.buildinginfo.api.model.visitors.EnergyVisitor;
import pl.put.poznan.buildinginfo.api.model.visitors.LightVisitor;
import pl.put.poznan.buildinginfo.api.model.visitors.WaterVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
        return buildings;
    }

    public Building getBuildingById(String id) {
        logger.info("Retrieving building with ID: {}", id);
        return buildings.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Level getLevelById(String buildingId, String levelId) {
        logger.info("Retrieving level with ID: {} from building with ID: {}", levelId, buildingId);
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
        logger.info("Retrieving room with ID: {} from level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
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
            AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
            building.accept(visitor);
            return new ValueInfo(visitor.getTotalArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalAreaOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
            level.accept(visitor);
            return new ValueInfo(visitor.getTotalArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAreaOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
            room.accept(visitor);
            return new ValueInfo(visitor.getTotalArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalVolumeOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
            building.accept(visitor);
            return new ValueInfo(visitor.getTotalVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getTotalVolumeOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
            level.accept(visitor);
            return new ValueInfo(visitor.getTotalVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getVolumeOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            AreaAndVolumeVisitor visitor = new AreaAndVolumeVisitor();
            room.accept(visitor);
            return new ValueInfo(visitor.getTotalVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getLightingPowerPerUnitAreaOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            LightVisitor visitor = new LightVisitor();
            room.accept(visitor);
            return new ValueInfo(visitor.getAverageLightPerUnitArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            LightVisitor visitor = new LightVisitor();
            level.accept(visitor);
            return new ValueInfo(visitor.getAverageLightPerUnitArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageLightingPowerPerUnitAreaOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            LightVisitor visitor = new LightVisitor();
            building.accept(visitor);
            return new ValueInfo(visitor.getAverageLightPerUnitArea());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            EnergyVisitor visitor = new EnergyVisitor();
            room.accept(visitor);
            return new ValueInfo(visitor.getAverageEnergyPerUnitVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            EnergyVisitor visitor = new EnergyVisitor();
            level.accept(visitor);
            return new ValueInfo(visitor.getAverageEnergyPerUnitVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            EnergyVisitor visitor = new EnergyVisitor();
            building.accept(visitor);
            return new ValueInfo(visitor.getAverageEnergyPerUnitVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getWaterConsumptionPerUnitVolumeOfRoom(String buildingId, String levelId, String roomId) {
        Room room = getRoomById(buildingId, levelId, roomId);
        if (room != null) {
            WaterVisitor visitor = new WaterVisitor();
            room.accept(visitor);
            return new ValueInfo(visitor.getWaterConsumptionPerUnitVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getWaterConsumptionPerUnitVolumeOfLevel(String buildingId, String levelId) {
        Level level = getLevelById(buildingId, levelId);
        if (level != null) {
            WaterVisitor visitor = new WaterVisitor();
            level.accept(visitor);
            return new ValueInfo(visitor.getWaterConsumptionPerUnitVolume());
        }
        return new ValueInfo(0);
    }

    public ValueInfo getWaterConsumptionPerUnitVolumeOfBuilding(String buildingId) {
        Building building = getBuildingById(buildingId);
        if (building != null) {
            WaterVisitor visitor = new WaterVisitor();
            building.accept(visitor);
            return new ValueInfo(visitor.getWaterConsumptionPerUnitVolume());
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
}
