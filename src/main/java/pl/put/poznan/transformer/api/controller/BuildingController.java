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
@RequestMapping("/buildings")
public class BuildingController {
    private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingService buildingService;

    @GetMapping("")
    public List<Building> getAllBuildings() {
        logger.info("Received request to get all buildings");
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{buildingId}")
    public Building getBuildingById(@PathVariable String buildingId) {
        logger.info("Received request to get building with ID: {}", buildingId);
        return buildingService.getBuildingById(buildingId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}")
    public Level getLevelById(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get level with ID: {} from building with ID: {}", levelId, buildingId);
        return buildingService.getLevelById(buildingId, levelId);
    }
    @GetMapping("/{buildingId}/levels/{levelId}/rooms/{roomId}")
    public Room getRoomById(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get room with ID: {} from level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        return buildingService.getRoomById(buildingId, levelId, roomId);
    }

    @GetMapping("/{buildingId}/area")
    public ValueInfo getTotalAreaOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get total area of building with ID: {}", buildingId);
        return buildingService.getTotalAreaOfBuilding(buildingId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/area")
    public ValueInfo getTotalAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get total area of level with ID: {} in building with ID: {}", levelId, buildingId);
        return buildingService.getTotalAreaOfLevel(buildingId, levelId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/rooms/{roomId}/area")
    public ValueInfo getAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get area of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        return buildingService.getAreaOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/{buildingId}/volume")
    public ValueInfo getTotalVolumeOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get total volume of building with ID: {}", buildingId);
        return buildingService.getTotalVolumeOfBuilding(buildingId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/volume")
    public ValueInfo getTotalVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get total volume of level with ID: {} in building with ID: {}", levelId, buildingId);
        return buildingService.getTotalVolumeOfLevel(buildingId, levelId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/rooms/{roomId}/volume")
    public ValueInfo getVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get volume of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        return buildingService.getVolumeOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/{buildingId}/lighting")
    public ValueInfo getAverageLightingPowerPerUnitAreaOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get average lighting power per unit area of building with ID: {}", buildingId);
        return buildingService.getAverageLightingPowerPerUnitAreaOfBuilding(buildingId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/lighting")
    public ValueInfo getAverageLightingPowerPerUnitAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get average lighting power per unit area of level with ID: {} in building with ID: {}", levelId, buildingId);
        return buildingService.getAverageLightingPowerPerUnitAreaOfLevel(buildingId, levelId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/rooms/{roomId}/lighting")
    public ValueInfo getLightingPowerPerUnitAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get lighting power per unit area of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        return buildingService.getLightingPowerPerUnitAreaOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/{buildingId}/heating")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(@PathVariable String buildingId) {
        logger.info("Received request to get average heating energy consumption per unit volume of building with ID: {}", buildingId);
        return buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(buildingId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/heating")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        logger.info("Received request to get average heating energy consumption per unit volume of level with ID: {} in building with ID: {}", levelId, buildingId);
        return buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(buildingId, levelId);
    }

    @GetMapping("/{buildingId}/levels/{levelId}/rooms/{roomId}/heating")
    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        logger.info("Received request to get heating energy consumption per unit volume of room with ID: {} in level with ID: {} in building with ID: {}", roomId, levelId, buildingId);
        return buildingService.getHeatingEnergyConsumptionPerUnitVolumeOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/{buildingId}/rooms-exceeding-heat-limit")
    public List<Room> getRoomsExceedingHeatLimit(@PathVariable String buildingId, @RequestParam double limit) {
        logger.info("Received request to get rooms exceeding heat limit in building with ID: {}", buildingId);
        return buildingService.getRoomsExceedingHeatLimit(buildingId,limit);
    }
}
