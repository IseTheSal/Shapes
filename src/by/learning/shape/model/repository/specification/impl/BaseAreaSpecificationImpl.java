package by.learning.shape.model.repository.specification.impl;

import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.repository.specification.Specification;
import by.learning.shape.model.warehouse.PyramidPropertyWarehouse;

public class BaseAreaSpecificationImpl implements Specification {

    private double from;
    private double to;

    public BaseAreaSpecificationImpl(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        long id = pyramid.getId();
        double baseArea = PyramidPropertyWarehouse.getWarehouse().get(id).getBaseArea();
        return (from >= baseArea && baseArea <= to);
    }
}
