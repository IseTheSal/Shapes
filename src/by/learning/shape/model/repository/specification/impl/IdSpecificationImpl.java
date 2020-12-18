package by.learning.shape.model.repository.specification.impl;

import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.repository.specification.Specification;

public class IdSpecificationImpl implements Specification {

    private long id;

    public IdSpecificationImpl(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        return (pyramid.getId() == id);
    }
}
