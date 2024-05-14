package pl.put.poznan.transformer.api.model;

public class Room {
    private String id;
    private String name;
    private double area;
    private double cube;
    private float heating;
    private double light;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCube() {
        return cube;
    }

    public void setCube(double cube) {
        this.cube = cube;
    }

    public float getHeating() {
        return heating;
    }

    public void setHeating(float heating) {
        this.heating = heating;
    }

    public double getLight() {
        return light;
    }

    public void setLight(double light) {
        this.light = light;
    }
}
