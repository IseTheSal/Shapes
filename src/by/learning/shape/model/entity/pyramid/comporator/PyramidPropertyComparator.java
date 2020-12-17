package by.learning.shape.model.entity.pyramid.comporator;

import by.learning.shape.model.entity.pyramid.PyramidProperty;

import java.util.Comparator;

public enum PyramidPropertyComparator implements Comparator<PyramidProperty> {
    BASE_AREA {
        @Override
        public int compare(PyramidProperty o1, PyramidProperty o2) {
            return Double.compare(o1.getBaseArea(), o2.getBaseArea());
        }
    },
    VOLUME {
        @Override
        public int compare(PyramidProperty o1, PyramidProperty o2) {
            return Double.compare(o1.getVolume(), o2.getVolume());
        }
    }
}
