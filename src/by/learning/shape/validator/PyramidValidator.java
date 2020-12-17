package by.learning.shape.validator;

import by.learning.shape.model.entity.pyramid.ParallelType;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.service.PyramidDefinerService;
import by.learning.shape.model.service.impl.PyramidServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidValidator {

    private static final Logger logger = LogManager.getLogger(PyramidValidator.class);

    private static final double INVALID_NUMBER = Double.NEGATIVE_INFINITY;
    private static final String POINT_REGEX = "-?\\d{1,6}(\\.\\d{0,6})?";

    public boolean isPyramidValid(Point point1, Point point2, Point point3, Point point4, Point height) {
        boolean isValid = true;
        if (isEqualsPoints(point1, point2, point3, point4, height)) {
            isValid = false;
        }
        if (!isSquareValid(point1, point2, point3, point4)) {
            isValid = false;
        }
        if (!isHeightCorrect(point1, point2, point3, point4, height)) {
            isValid = false;
        }
        if (!isPyramidParallelToAxis(point1, point2, point3, point4)) {
            isValid = false;
        }
        return isValid;
    }

    public boolean isPointValid(String x, String y, String z) {
        Pattern pattern = Pattern.compile(POINT_REGEX);
        Matcher matcherX = pattern.matcher(x);
        Matcher matcherY = pattern.matcher(y);
        Matcher matcherZ = pattern.matcher(z);
        boolean result = (matcherX.matches() && matcherY.matches() && matcherZ.matches());
        return result;
    }

    public boolean isEqualsPoints(Point point1, Point point2, Point point3, Point point4, Point height) {
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

    public boolean isPyramidParallelToAxis(Point point1, Point point2, Point point3, Point point4) {
        PyramidDefinerService pyramidDefiner = new PyramidDefinerService();
        int value = pyramidDefiner.defineBaseParallel(point1, point2, point3, point4).getValue();
        return value > 0;
    }

    public boolean isHeightCorrect(Point point1, Point point2, Point point3, Point point4, Point height) {
        boolean result = false;
        PyramidDefinerService pyramidDefiner = new PyramidDefinerService();
        ParallelType parallelType = pyramidDefiner.defineBaseParallel(point1, point2, point3, point4);
        double crossX = INVALID_NUMBER;
        double crossY = INVALID_NUMBER;
        double crossZ = INVALID_NUMBER;
        switch (parallelType) {
            case OXZ:
                crossZ = (point1.getZ() + point3.getZ()) / 2;
                crossX = (point1.getX() + point3.getX()) / 2;
                crossY = height.getY();
                break;
            case OXY:
                crossY = (point1.getY() + point3.getY()) / 2;
                crossX = (point1.getX() + point3.getX()) / 2;
                crossZ = height.getZ();
                break;
            case OZY:
                crossZ = (point1.getZ() + point3.getZ()) / 2;
                crossY = (point1.getY() + point3.getY()) / 2;
                crossX = height.getX();
                break;
        }
        if ((height.getX() == crossX) && (height.getY() == crossY) && (height.getZ() == crossZ)
                && (crossX != INVALID_NUMBER) && (crossY != INVALID_NUMBER) && (crossZ != INVALID_NUMBER)) {
            result = true;
            logger.info("Height point is correct");
        }
        return result;
    }
}
