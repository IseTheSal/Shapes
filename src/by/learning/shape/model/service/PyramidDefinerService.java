package by.learning.shape.model.service;

import by.learning.shape.model.entity.ParallelType;
import by.learning.shape.model.entity.Point;
import by.learning.shape.model.entity.Pyramid;

public class PyramidDefinerService {

    public ParallelType defineBaseParallel(Pyramid pyramid) {
        ParallelType result = ParallelType.NOT_PARALLEL;
        Point basePointOne = pyramid.getBase().getPointOne();
        Point basePointTwo = pyramid.getBase().getPointTwo();
        Point basePointThree = pyramid.getBase().getPointThree();
        Point basePointFour = pyramid.getBase().getPointFour();

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
