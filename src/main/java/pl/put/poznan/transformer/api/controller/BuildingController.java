package pl.put.poznan.transformer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.api.model.Building;
import pl.put.poznan.transformer.api.model.Level;
import pl.put.poznan.transformer.api.model.Room;
import pl.put.poznan.transformer.api.model.ValueInfo;
import pl.put.poznan.transformer.api.service.BuildingService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BuildingController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        logger.info("Received request to get all buildings");
        List<Building> buildings = buildingService.getAllBuildings();
        logger.debug("Returning buildings: {}", buildings);
        return buildings;
    }

    @GetMapping("/buildings/{buildingId}")
    public Building getBuildingById(@PathVariable String buildingId) {
        logger.info("Received request to get building with ID: {}", buildingId);
        Building building = buildingService.getBuildingById(buildingId);
        logger.debug("Returning building: {}", building);
        return building;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}")
    public Level getLevelById(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get level with ID: {} from building with ID: {}", levelId, buildingId);
        Level level = buildingService.getLevelById(buildingId, levelId);
        logger.debug("Returning level: {}", level);
        return level;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}")
    public Room getRoomById(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get room with ID: {} from level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        Room room = buildingService.getRoomById(buildingId, levelId, roomId);
        logger.debug("Returning room: {}", room);
        return room;
    }

    @GetMapping("/buildings/{buildingId}/area")
    public ValueInfo getTotalAreaOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get total area of building with ID: {}", buildingId);
        ValueInfo area = buildingService.getTotalAreaOfBuilding(buildingId);
        logger.debug("Returning total area of building: {}", area);
        return area;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/area")
    public ValueInfo getTotalAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get total area of level with ID: {} in building with ID: {}", levelId, buildingId);
        ValueInfo area = buildingService.getTotalAreaOfLevel(buildingId, levelId);
        logger.debug("Returning total area of level: {}", area);
        return area;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/area")
    public ValueInfo getAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get area of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        ValueInfo area = buildingService.getAreaOfRoom(buildingId, levelId, roomId);
        logger.debug("Returning area of room: {}", area);
        return area;
    }

    @GetMapping("/buildings/{buildingId}/volume")
    public ValueInfo getTotalVolumeOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get total volume of building with ID: {}", buildingId);
        ValueInfo volume = buildingService.getTotalVolumeOfBuilding(buildingId);
        logger.debug("Returning total volume of building: {}", volume);
        return volume;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/volume")
    public ValueInfo getTotalVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get total volume of level with ID: {} in building with ID: {}", levelId, buildingId);
        ValueInfo volume = buildingService.getTotalVolumeOfLevel(buildingId, levelId);
        logger.debug("Returning total volume of level: {}", volume);
        return volume;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/volume")
    public ValueInfo getVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get volume of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        ValueInfo volume = buildingService.getVolumeOfRoom(buildingId, levelId, roomId);
        logger.debug("Returning volume of room: {}", volume);
        return volume;
    }

    @GetMapping("/buildings/{buildingId}/lighting")
    public ValueInfo getAverageLightingPowerPerUnitAreaOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get average lighting power per unit area of building with ID: {}", buildingId);
        ValueInfo lighting = buildingService.getAverageLightingPowerPerUnitAreaOfBuilding(buildingId);
        logger.debug("Returning average lighting power per unit area of building: {}", lighting);
        return lighting;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/lighting")
    public ValueInfo getAverageLightingPowerPerUnitAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get average lighting power per unit area of level with ID: {} in building with ID: {}", levelId, buildingId);
        ValueInfo lighting = buildingService.getAverageLightingPowerPerUnitAreaOfLevel(buildingId, levelId);
        logger.debug("Returning average lighting power per unit area of level: {}", lighting);
        return lighting;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/lighting")
    public ValueInfo getLightingPowerPerUnitAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get lighting power per unit area of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        ValueInfo lighting = buildingService.getLightingPowerPerUnitAreaOfRoom(buildingId, levelId, roomId);
        logger.debug("Returning lighting power per unit area of room: {}", lighting);
        return lighting;
    }

    @GetMapping("/buildings/{buildingId}/heating")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get average heating energy consumption per unit volume of building with ID: {}", buildingId);
        ValueInfo heating = buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(buildingId);
        logger.debug("Returning average heating energy consumption per unit volume of building: {}", heating);
        return heating;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/heating")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get average heating energy consumption per unit volume of level with ID: {} in building with ID: {}", levelId, buildingId);
        ValueInfo heating = buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(buildingId, levelId);
        logger.debug("Returning average heating energy consumption per unit volume of level: {}", heating);
        return heating;
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/heating")
    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get heating energy consumption per unit volume of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        ValueInfo heating = buildingService.getHeatingEnergyConsumptionPerUnitVolumeOfRoom(buildingId, levelId, roomId);
        logger.debug("Returning heating energy consumption per unit volume of room: {}", heating);
        return heating;
    }

    @GetMapping("/buildings/{buildingId}/rooms-exceeding-heat-limit")
    public List<Room> getRoomsExceedingHeatLimit(@PathVariable String buildingId, @RequestParam double limit) {
        return buildingService.getRoomsExceedingHeatLimit(buildingId, limit);
    }
}
