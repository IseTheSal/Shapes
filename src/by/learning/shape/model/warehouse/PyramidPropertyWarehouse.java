package by.learning.shape.model.warehouse;

import by.learning.shape.model.entity.pyramid.PyramidProperty;

import java.util.HashMap;
import java.util.Map;

public class PyramidPropertyWarehouse {

    private final static PyramidPropertyWarehouse warehouse = new PyramidPropertyWarehouse();

    private Map<Long, PyramidProperty> pyramidProperty = new HashMap<>();

    public static PyramidPropertyWarehouse getWarehouse() {
        return warehouse;
    }

    public int size() {
        return pyramidProperty.size();
    }

    public PyramidProperty get(Long id) {
        return pyramidProperty.get(id);
    }

    public void put(Long id, PyramidProperty property) {
        pyramidProperty.put(id, property);
    }

    public void remove(Long id) {
        pyramidProperty.remove(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PyramidPropertyWarehouse that = (PyramidPropertyWarehouse) o;

        return pyramidProperty != null ? pyramidProperty.equals(that.pyramidProperty) : that.pyramidProperty == null;
    }

    @Override
    public int hashCode() {
        return pyramidProperty != null ? pyramidProperty.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PyramidPropertyWarehouse{");
        sb.append("pyramidProperty=").append(pyramidProperty);
        sb.append('}');
        return sb.toString();
    }
}
