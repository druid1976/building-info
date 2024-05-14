package pl.put.poznan.transformer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.api.model.ValueInfo;
import pl.put.poznan.transformer.api.model.Building;
import pl.put.poznan.transformer.api.model.Level;
import pl.put.poznan.transformer.api.model.Room;
import pl.put.poznan.transformer.api.service.BuildingService;

import java.io.IOException;
import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/building/{id}")
    public Building getBuilding(@PathVariable String id) throws IOException {
        return buildingService.getBuildingById(id);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}")
    public Level getLevel(@PathVariable String buildingId, @PathVariable String levelId) throws IOException {
        return buildingService.getLevelById(buildingId, levelId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/rooms/{roomId}")
    public Room getRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) throws IOException {
        return buildingService.getRoomById(buildingId, levelId, roomId);
    }

    /* AREA INFO ENDPOINTS */
    @GetMapping("/building/{buildingId}/total-area")
    public ValueInfo getTotalAreaOfBuilding(@PathVariable String buildingId) {
        return buildingService.getTotalAreaOfBuilding(buildingId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/total-area")
    public ValueInfo getTotalAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getTotalAreaOfLevel(buildingId, levelId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/rooms/{roomId}/total-area")
    public ValueInfo getAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getAreaOfRoom(buildingId, levelId, roomId);
    }

    /* VOLUME INFO ENDPOINTS */
    @GetMapping("/building/{buildingId}/total-volume")
    public ValueInfo getTotalVolumeOfBuilding(@PathVariable String buildingId) {
        return buildingService.getTotalVolumeOfBuilding(buildingId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/total-volume")
    public ValueInfo getTotalVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getTotalVolumeOfLevel(buildingId, levelId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/rooms/{roomId}/total-volume")
    public ValueInfo getVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getVolumeOfRoom(buildingId, levelId, roomId);
    }

    /* LIGHTNING POWER ENDPOINTS */
    @GetMapping("/building/{buildingId}/lighting-power-per-unit-area")
    public ValueInfo getLightingPowerPerUnitAreaOfBuilding(@PathVariable String buildingId) {
        return buildingService.getAverageLightingPowerPerUnitAreaOfBuilding(buildingId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/lighting-power-per-unit-area")
    public ValueInfo getLightingPowerPerUnitAreaOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getAverageLightingPowerPerUnitAreaOfLevel(buildingId, levelId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/rooms/{roomId}/lighting-power-per-unit-area")
    public ValueInfo getLightingPowerPerUnitAreaOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getLightingPowerPerUnitAreaOfRoom(buildingId, levelId, roomId);
    }

    /* HEATING ENDPOINTS */
    @GetMapping("/building/{buildingId}/heating-energy-consumption-per-unit-volume")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(@PathVariable String buildingId) {
        return buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfBuilding(buildingId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/heating-energy-consumption-per-unit-volume")
    public ValueInfo getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(@PathVariable String buildingId, @PathVariable String levelId) {
        return buildingService.getAverageHeatingEnergyConsumptionPerUnitVolumeOfLevel(buildingId, levelId);
    }

    @GetMapping("/building/{buildingId}/levels/{levelId}/rooms/{roomId}/heating-energy-consumption-per-unit-volume")
    public ValueInfo getHeatingEnergyConsumptionPerUnitVolumeOfRoom(@PathVariable String buildingId, @PathVariable String levelId, @PathVariable String roomId) {
        return buildingService.getHeatingEnergyConsumptionPerUnitVolumeOfRoom(buildingId, levelId, roomId);
    }

    /* EXCEEDING LIMIT ENDPOINT */
    @GetMapping("/building/{buildingId}/rooms-exceeding-heat-limit")
    public List<Room> getRoomsExceedingHeatLimit(@PathVariable String buildingId, @RequestParam double limit) {
        return buildingService.getRoomsExceedingHeatLimit(buildingId, limit);
    }

}
