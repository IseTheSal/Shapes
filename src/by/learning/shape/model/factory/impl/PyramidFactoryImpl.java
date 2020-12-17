package by.learning.shape.model.factory.impl;

import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Square;
import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.factory.FigureFactory;
import by.learning.shape.validator.PyramidValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PyramidFactoryImpl extends FigureFactory<Pyramid> {
    private final static Logger logger = LogManager.getLogger(PyramidFactoryImpl.class);

    private final static int POINT1_INDEX = 0;
    private final static int POINT2_INDEX = 1;
    private final static int POINT3_INDEX = 2;
    private final static int POINT4_INDEX = 3;
    private final static int HEIGHT_INDEX = 4;


    @Override
    public Optional<Pyramid> createInstance(List<Point> points) {
        Optional<Pyramid> result = Optional.empty();
        PyramidValidator pyramidValidator = new PyramidValidator();
        Point point1 = points.get(POINT1_INDEX);
        Point point2 = points.get(POINT2_INDEX);
        Point point3 = points.get(POINT3_INDEX);
        Point point4 = points.get(POINT4_INDEX);
        Point height = points.get(HEIGHT_INDEX);
        boolean isPyramidValid = pyramidValidator.isPyramidValid(point1, point2, point3, point4, height);
        if (isPyramidValid) {
            Square square = new Square(point1, point2, point3, point4);
            result = Optional.of(new Pyramid(height, square));
        } else {
            logger.warn("Invalid pyramid");
        }
        return result;
    }
}
