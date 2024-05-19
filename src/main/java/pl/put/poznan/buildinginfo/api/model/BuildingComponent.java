package pl.put.poznan.buildinginfo.api.model;

import pl.put.poznan.buildinginfo.api.model.visitors.BuildingComponentVisitor;

/**
 * The BuildingComponent interface represents a generic building component that can be part of a building structure.
 * It provides methods to calculate various properties of the building component and accept visitors for further operations.
 */
public interface BuildingComponent {

    /**
     * Calculates the area of the building component.
     * @return the area of the building component.
     */
    double calculateArea();

    /**
     * Calculates the volume of the building component.
     * @return the volume of the building component.
     */
    double calculateVolume();

    /**
     * Calculates the total lighting power required for the building component.
     * @return the total lighting power required for the building component.
     */
    double calculateLightingPower();

    /**
     * Calculates the total heating energy required for the building component.
     * @return the total heating energy required for the building component.
     */
    double calculateHeatingEnergy();

    /**
     * Accepts a visitor to perform operations on the building component.
     * @param visitor the visitor to accept.
     */
    void accept(BuildingComponentVisitor visitor);
}
