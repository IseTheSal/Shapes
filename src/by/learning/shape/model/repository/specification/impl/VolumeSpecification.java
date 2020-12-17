package by.learning.shape.model.repository.specification.impl;

import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.repository.specification.Specification;
import by.learning.shape.model.warehouse.PyramidPropertyWarehouse;

public class VolumeSpecification implements Specification {

    private double from;
    private double to;

    public VolumeSpecification(double from, double to) {
        this.from = from;
        this.to = to;
    }


    @Override
    public boolean specify(Pyramid pyramid) {
        long id = pyramid.getId();
        double volume = PyramidPropertyWarehouse.getWarehouse().get(id).getVolume();
        return (from >= volume && volume <= to);
    }
}
