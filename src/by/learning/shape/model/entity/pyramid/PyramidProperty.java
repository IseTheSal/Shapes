package by.learning.shape.model.entity.pyramid;

public class PyramidProperty {

    private double volume;
    private double baseArea;
    private ParallelType parallelType;

    public PyramidProperty(double volume, double baseArea) {
        this.volume = volume;
        this.baseArea = baseArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }
}
