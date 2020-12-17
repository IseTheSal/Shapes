package by.learning.shape.model.service.impl;

import by.learning.shape.exception.ServiceException;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Square;
import by.learning.shape.model.entity.pyramid.ParallelType;
import by.learning.shape.model.entity.pyramid.Pyramid;
import by.learning.shape.model.service.PyramidDefinerService;
import by.learning.shape.model.service.PyramidService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidServiceImpl implements PyramidService {

    private static final Logger logger = LogManager.getLogger(PyramidServiceImpl.class);

    @Override
    public double calcSideLength(Point p1, Point p2) {
        double deltaY = Math.abs(p1.getY() - p2.getY());
        double deltaX = Math.abs(p1.getX() - p2.getX());
        double deltaZ = Math.abs(p1.getZ() - p2.getZ());
        double result = Math.sqrt(deltaY * deltaY + deltaX * deltaX + deltaZ * deltaZ);
        return result;
    }

    @Override
    public double calcBaseArea(Pyramid pyramid) {
        Square square = pyramid.getBase();
        Point point1 = square.getPointOne();
        Point point2 = square.getPointTwo();
        double sideLength = calcSideLength(point1, point2);
        double resultArea = sideLength * sideLength;
        return resultArea;
    }


    @Override
    public double calcHeightLength(Pyramid pyramid) throws ServiceException {
        double result;
        PyramidDefinerService pyramidDefiner = new PyramidDefinerService();
        ParallelType parallelType = pyramidDefiner.defineBaseParallel(pyramid);
        Point heightPoint = pyramid.getHeight();
        Square base = pyramid.getBase();
        Point basePoint = base.getPointOne();
        switch (parallelType) {
            case OXY:
                result = Math.abs(heightPoint.getZ() - basePoint.getZ());
                break;
            case OXZ:
                result = Math.abs(heightPoint.getY() - basePoint.getY());
                break;
            case OZY:
                result = Math.abs(heightPoint.getX() - basePoint.getX());
                break;
            case NOT_PARALLEL:
            default:
                throw new ServiceException("Pyramid isn`t parallel");
        }
        return result;
    }

    @Override
    public double calcTriangleArea(Point point1, Point point2, Point point3) {
        double a = calcSideLength(point1, point2);
        double b = calcSideLength(point2, point3);
        double c = calcSideLength(point3, point1);
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    @Override
    public double calcPyramidSurfaceArea(Pyramid pyramid) {
        double result = 0;
        Point pointOne = pyramid.getBase().getPointOne();
        Point pointTwo = pyramid.getBase().getPointTwo();
        Point heightPoint = pyramid.getHeight();
        result += calcTriangleArea(pointOne, pointTwo, heightPoint) * 4;
        result += calcBaseArea(pyramid);
        return result;
    }

    @Override
    public double calcPyramidVolume(Pyramid pyramid) throws ServiceException {
        double baseArea = calcBaseArea(pyramid);
        double heightLength = calcHeightLength(pyramid);
        double result = baseArea * heightLength / 3;
        return result;
    }

    @Override
    public boolean isBaseOnCoordinatePlane(Pyramid pyramid) {
        boolean result = false;
        StringBuilder loggerOutput = new StringBuilder();
        Square base = pyramid.getBase();
        Point pointOne = base.getPointOne();
        Point pointTwo = base.getPointTwo();
        Point pointThree = base.getPointThree();
        Point pointFour = base.getPointFour();
        if (pointOne.getX() == 0 || pointTwo.getX() == 0 || pointThree.getX() == 0 || pointFour.getX() == 0) {
            result = true;
            loggerOutput.append("Base planes on X ");
        }
        if (pointOne.getY() == 0 || pointTwo.getY() == 0 || pointThree.getY() == 0 || pointFour.getY() == 0) {
            result = true;
            loggerOutput.append(" Base planes on Y ");
        }
        if (pointOne.getZ() == 0 || pointTwo.getZ() == 0 || pointThree.getZ() == 0 || pointFour.getZ() == 0) {
            result = true;
            loggerOutput.append(" Base planes on Z");
        }
        logger.info(loggerOutput);
        return result;
    }
}
