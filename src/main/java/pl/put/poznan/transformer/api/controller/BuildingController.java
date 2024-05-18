package pl.put.poznan.transformer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.api.model.Building;
import pl.put.poznan.transformer.api.model.Level;
import pl.put.poznan.transformer.api.model.Room;
import pl.put.poznan.transformer.api.model.ValueInfo;
import pl.put.poznan.transformer.api.service.BuildingService;

import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/buildings/{buildingId}")
    public Building getBuildingById(@PathVariable String buildingId) {
        return buildingService.getBuildingById(buildingId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}")
    public Level getLevelById(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getLevelById(buildingId, levelId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}")
    public Room getRoomById(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getRoomById(buildingId, levelId, roomId);
    }

    @GetMapping("/buildings/{buildingId}/total-area")
    public ValueInfo getTotalAreaOfBuilding(@PathVariable String buildingId) {
        return buildingService.getTotalAreaOfBuilding(buildingId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/total-area")
    public ValueInfo getTotalAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getTotalAreaOfLevel(buildingId, levelId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/area")
    public ValueInfo getAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getAreaOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/buildings/{buildingId}/total-volume")
    public ValueInfo getTotalVolumeOfBuilding(@PathVariable String buildingId) {
        return buildingService.getTotalVolumeOfBuilding(buildingId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/total-volume")
    public ValueInfo getTotalVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getTotalVolumeOfLevel(buildingId, levelId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/total-volume")
    public ValueInfo getVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getVolumeOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/buildings/{buildingId}/lighting-power-per-unit-area")
    public ValueInfo getLightingPowerPerUnitAreaOfBuilding(@PathVariable String buildingId) {
        return buildingService.getAverageLightingPowerPerUnitAreaOfBuilding(buildingId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/lighting-power-per-unit-area")
    public ValueInfo getLightingPowerPerUnitAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getAverageLightingPowerPerUnitAreaOfLevel(buildingId, levelId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/lighting-power-per-unit-area")
    public ValueInfo getLightingPowerPerUnitAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getLightingPowerPerUnitAreaOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/buildings/{buildingId}/heating-energy-consumption-per-unit-volume")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(@PathVariable String buildingId) {
        return buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(buildingId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/heating-energy-consumption-per-unit-volume")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(buildingId, levelId);
    }

    @GetMapping("/buildings/{buildingId}/levels/{levelId}/rooms/{roomId}/heating-energy-consumption-per-unit-volume")
    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getHeatingEnergyConsumptionPerUnitVolumeOfRoom(buildingId, levelId, roomId);
    }

    @GetMapping("/buildings/{buildingId}/rooms-exceeding-heat-limit")
    public List<Room> getRoomsExceedingHeatLimit(@PathVariable String buildingId, @RequestParam double limit) {
        return buildingService.getRoomsExceedingHeatLimit(buildingId, limit);
    }
}
