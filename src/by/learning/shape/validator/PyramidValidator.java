package by.learning.shape.validator;

import by.learning.shape.model.entity.ParallelType;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Pyramid;
import by.learning.shape.model.service.PyramidDefinerService;
import by.learning.shape.model.service.impl.PyramidServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidValidator {

    private static final Logger logger = LogManager.getLogger(PyramidValidator.class);
    private final double INVALID_NUMBER = Double.NEGATIVE_INFINITY;

    public boolean notSamePoints(Point point1, Point point2, Point point3, Point point4, Point height) {
        boolean isEquals = true;
        if (point1.equals(point2) || point1.equals(point3) || point1.equals(point4) || point1.equals(height) ||
                point2.equals(point3) || point2.equals(point4) || point2.equals(height) ||
                point3.equals(point4) || point3.equals(height)
                || point4.equals(height)) {
            isEquals = false;
            logger.info("Points equals");
        }
        return isEquals;
    }

    public boolean isSquareValid(Point point1, Point point2, Point point3, Point point4) {
        boolean result = false;
        PyramidServiceImpl pyramidService = new PyramidServiceImpl();
        double side1 = pyramidService.calcSideLength(point1, point2);
        double side2 = pyramidService.calcSideLength(point2, point3);
        double side3 = pyramidService.calcSideLength(point3, point4);
        double side4 = pyramidService.calcSideLength(point4, point1);

        double diagonal1 = pyramidService.calcSideLength(point1, point3);
        double diagonal2 = pyramidService.calcSideLength(point2, point4);

        double diagonalPifagor = Math.sqrt(side1 * side1 + side2 * side2);

        if ((side1 == side2) && (side2 == side3) && (side4 == side1)
                && (diagonal1 == diagonal2) && (diagonal2 == diagonalPifagor)) {
            result = true;
            logger.info("Square is valid");
        }
        return result;
    }

    public boolean isPyramidParallelToAxis(Pyramid pyramid) {
        PyramidDefinerService pyramidDefiner = new PyramidDefinerService();
        int value = pyramidDefiner.defineBaseParallel(pyramid).getValue();
        return value > 0;
    }

    public boolean isHeightCorrect(Pyramid pyramid) {
        boolean result = false;
        Point heightPoint = pyramid.getHeight();
        Point pointOne = pyramid.getBase().getPointOne();
        Point pointThree = pyramid.getBase().getPointThree();
        PyramidDefinerService pyramidDefiner = new PyramidDefinerService();
        ParallelType parallelType = pyramidDefiner.defineBaseParallel(pyramid);
        double crossZ = INVALID_NUMBER;
        double crossX = INVALID_NUMBER;
        double crossY = INVALID_NUMBER;
        switch (parallelType) {
            case OXZ:
                crossZ = (pointOne.getZ() + pointThree.getZ()) / 2;
                crossX = (pointOne.getX() + pointThree.getX()) / 2;
                crossY = heightPoint.getY();
                break;
            case OXY:
                crossY = (pointOne.getY() + pointThree.getY()) / 2;
                crossX = (pointOne.getX() + pointThree.getX()) / 2;
                crossZ = heightPoint.getZ();
                break;
            case OZY:
                crossZ = (pointOne.getZ() + pointThree.getZ()) / 2;
                crossY = (pointOne.getY() + pointThree.getY()) / 2;
                crossX = heightPoint.getX();
                break;
        }
        if ((heightPoint.getX() == crossX) && (heightPoint.getY() == crossY) && (heightPoint.getZ() == crossZ)) {
            result = true;
            logger.info("Height point is correct");
        }
        return result;
    }
}
