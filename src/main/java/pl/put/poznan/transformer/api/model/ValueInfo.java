package pl.put.poznan.transformer.api.model;

public class ValueInfo {
    private double totalValue;

    public ValueInfo(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
