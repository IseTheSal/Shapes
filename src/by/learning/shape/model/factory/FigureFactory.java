package by.learning.shape.model.factory;

import by.learning.shape.model.entity.Figure;
import by.learning.shape.model.entity.Point;

import java.util.List;
import java.util.Optional;

public abstract class FigureFactory<T extends Figure> {
    public abstract Optional<T> createInstance(List<Point> points);
}
