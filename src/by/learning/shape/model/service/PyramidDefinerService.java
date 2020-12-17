package by.learning.shape.model.service;

import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.pyramid.ParallelType;
import by.learning.shape.model.entity.pyramid.Pyramid;

public class PyramidDefinerService {

    public ParallelType defineBaseParallel(Pyramid pyramid) {
        Point basePointOne = pyramid.getBase().getPointOne();
        Point basePointTwo = pyramid.getBase().getPointTwo();
        Point basePointThree = pyramid.getBase().getPointThree();
        Point basePointFour = pyramid.getBase().getPointFour();

        ParallelType result = defineParallelType(basePointOne, basePointTwo, basePointThree, basePointFour);
        return result;
    }

    public ParallelType defineBaseParallel(Point point1, Point point2, Point point3, Point point4) {
        ParallelType result = defineParallelType(point1, point2, point3, point4);
        return result;
    }

    private ParallelType defineParallelType(Point basePointOne, Point basePointTwo, Point basePointThree, Point basePointFour) {
        ParallelType result = ParallelType.NOT_PARALLEL;
        if ((basePointFour.getX() == basePointOne.getX()) && (basePointTwo.getX() == basePointThree.getX())
                && basePointFour.getX() == basePointThree.getX()) {
            result = ParallelType.OZY;
        } else if ((basePointFour.getY() == basePointOne.getY()) && (basePointTwo.getY() == basePointThree.getY())
                && (basePointFour.getY() == basePointThree.getY())) {
            result = ParallelType.OXZ;
        } else if ((basePointFour.getZ() == basePointOne.getZ()) && (basePointTwo.getZ() == basePointThree.getZ())
                && basePointFour.getZ() == basePointThree.getZ()) {
            result = ParallelType.OXY;
        }
        return result;
    }
}
