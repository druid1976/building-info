// BuildingComponent.java
package pl.put.poznan.buildinginfo.api.model;

import pl.put.poznan.buildinginfo.api.model.visitors.BuildingComponentVisitor;

public interface BuildingComponent {
    double calculateArea();

    double calculateVolume();

    double calculateLightingPower();

    double calculateHeatingEnergy();

    void accept(BuildingComponentVisitor visitor);
}