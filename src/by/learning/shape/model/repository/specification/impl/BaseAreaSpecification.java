package by.learning.shape.model.repository.specification.impl;

import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.repository.specification.Specification;
import by.learning.shape.model.warehouse.PyramidPropertyWarehouse;

public class BaseAreaSpecification implements Specification {

    private double from;
    private double to;

    public BaseAreaSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        long id = pyramid.getId();
        double baseArea = PyramidPropertyWarehouse.getWarehouse().getProperty(id).getBaseArea();
        return (from >= baseArea && baseArea <= to);
    }
}
