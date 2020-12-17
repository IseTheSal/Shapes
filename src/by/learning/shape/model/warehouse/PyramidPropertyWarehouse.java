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

    public int findSize() {
        return pyramidProperty.size();
    }

    public PyramidProperty getProperty(Long id) {
        return pyramidProperty.get(id);
    }

    public void putProperty(Long id, PyramidProperty property) {
        pyramidProperty.put(id, property);
    }

    public void removeProperty(Long id) {
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
